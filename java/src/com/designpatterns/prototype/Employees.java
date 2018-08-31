package com.designpatterns.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable{

	private List<String> empList;
	
	public Employees() {
		this.empList = new ArrayList<String>();
	}
	
	public Employees(List<String> emp) {
		this.empList = emp;
	}
	
	public void loadData() {
		empList.add("Ram");
		empList.add("Shyam");
		empList.add("Rahul");
		empList.add("Piyush");
	}
	
	public List<String> getEmployees() {
		return empList;
	}
	
	public Object clone() throws CloneNotSupportedException{
		List<String> temp = new ArrayList<>();
		for(String s : this.getEmployees()) {
			temp.add(s);
		}
		return new Employees(temp);
	}
	
}
