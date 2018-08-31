package com.designpatterns;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Singleton implements Serializable{   //Cloneable {
	
	public static Singleton singleton = null;
	
	private Singleton() {
		if(singleton != null) {
			throw new RuntimeException("Cannot create, please use getInstance() method");
		}
	}
	
	public static Singleton getInstance() {
		if(singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	private Object readResolve() {
		return singleton;
	}
}

class TestSingleton{
	public static final Logger logger = LoggerFactory.getLogger(TestSingleton.class);
	
	public static void main(String[] args) throws Exception {
		
		logger.info("SLF4J Test");
		Singleton s = Singleton.getInstance();
//		Singleton s1 = Singleton.getInstance();
		
	/*	Class clazz = Class.forName("com.designpatterns.Singleton");
		Constructor<Singleton> cont = clazz.getDeclaredConstructor();
		cont.setAccessible(true);
		Singleton s1 = cont.newInstance();*/
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("demo.ser"));
		oos.writeObject(s);
		oos.flush();
		oos.close();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("demo.ser"));
		Singleton s1 = (Singleton)ois.readObject();
		
//		Singleton s1 = (Singleton) s.clone();
		
/*		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(TestSingleton::useSingleton);
		service.submit(TestSingleton::useSingleton);
		service.shutdown();*/
		
		print(s);
		print(s1);
	}
	
	public static void print(Object obj) {
		System.out.println("Object : "+obj+ " , Hashcode : "+obj.hashCode());
	}
	
	public static void useSingleton() {
		Singleton singleton = Singleton.getInstance();
		print(singleton);
	}
}
