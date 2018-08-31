package com.misc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.SynchronousQueue;

public class ReflectionDemo {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {
		Test1 t = new Test1();
		Class c = t.getClass();
		Constructor<Test1>[] con = c.getConstructors();
		
		for(Constructor constructor : con) {
			constructor.newInstance();
			System.out.println("constructor done");
		}
		
		Method[] methods = c.getMethods();
		for(Method method : methods) {
			System.out.println(method.getName());
		}
		
		Method method = c.getMethod("method1");
		method.invoke(t);
		
		method = c.getMethod("method2", int.class);
		method.invoke(t, 10);
		
		method = c.getDeclaredMethod("method3");
//		method = c.getMethod("method3");
		method.setAccessible(true);
		method.invoke(t);
		
		Field field = c.getDeclaredField("s");
		field.setAccessible(true);
		field.set(t, "hi there");
		System.out.println(field.get(t));
		Map.Entry<Integer, Integer> m;
		
		printlist(new ArrayList<Integer>() {
			{ add(1);add(3);add(5);}
		});
	}
	
	
	  private static <T> void printlist(List<T> list) 
	    {
	 
	        System.out.println(list);
	    }

}

class Test1 {
	private String s;
	
	public Test1() {
		System.out.println("Constructor called");
	}
	
	public void method1() {
		System.out.println("method1 called");
	}
	
	public void method2(int a) {
		System.out.println("method2 called");
	}
	
	private void method3() {
		System.out.println("method3 called");
	}
}
