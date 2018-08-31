package com.misc;

import java.util.ArrayList;

public class Snapshot {
    private ArrayList<Integer> data = new ArrayList<Integer>();
    private ArrayList<Integer> ini = new ArrayList<Integer>();
    
    public Snapshot(ArrayList<Integer> data)
    {
/*    	for (int i=0;i<data.size();i++) {
    		ini.set(i, data.get(i));
    	}*/
    	
    	ini.addAll(data);
    	this.data = data;
    }
    
    public ArrayList<Integer> restore()
    {
        return this.ini;
    }
    
    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        Snapshot snap = new Snapshot(list);
        list.set(0, 3);
        list = snap.restore();
        System.out.println(list); // Should output [1, 2]
        list.add(4);
        list = snap.restore();
        System.out.println(list); // Should output [1, 2]
    }
}