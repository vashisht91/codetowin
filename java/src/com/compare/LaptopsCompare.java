package com.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LaptopsCompare {

	public static void main(String[] args) {
		List<Laptop> laptops = new ArrayList<>();
		laptops.add(new Laptop("Dell", 4, 21000));
		laptops.add(new Laptop("Mac", 8, 41000));
		laptops.add(new Laptop("Asus", 6, 51000));
		
		Collections.sort(laptops);
		for(Laptop l : laptops) {
			System.out.println(l.toString());
		}
		
		Comparator<Laptop> compare = new Comparator<Laptop>() {

			@Override
			public int compare(Laptop o1, Laptop o2) {
				if(o1.getPrice() > o2.getPrice()) {
					return 1;
				}
				else if (o1.getPrice() < o2.getPrice()) {
					return -1;
				}
				else {
					return 0;
				}
			}
		};
		
		Collections.sort(laptops, compare);
		for(Laptop l : laptops) {
			System.out.println(l.toString());
		}
	}

}
