package com.piy.crud;

import java.util.HashMap;
import java.util.Map;

public class ElementDao {
	
	private static Map<String, Element> contentProvider = new HashMap<>();
	private static ElementDao el = null;
	
	private ElementDao() {
		Element element = new Element();
		element.setDescription("Read http://www.vogella.com/tutorials/REST/article.html");
        contentProvider.put("1", element);
        
        element = new Element("2", "Do something");
        element.setDescription("Read complete http://www.vogella.com");
        contentProvider.put("2", element);
	}
	
	public static Map<String, Element> getElement() {
		if(el == null) {
			el = new ElementDao();
		}
		return contentProvider;
	}

}
