package com.designpatterns.prototype;

public class PrototypeDemo {

	public static void main(String[] args) throws CloneNotSupportedException {
		Employees e1 = new Employees();
		e1.loadData();
		Employees e2 = (Employees) e1.clone();
		Employees e3 = (Employees) e1.clone();
		e2.getEmployees().add("Ravi");
		e3.getEmployees().remove(1);
		System.out.println(e1.getEmployees());
		System.out.println(e2.getEmployees());
		System.out.println(e3.getEmployees());
	}

}
