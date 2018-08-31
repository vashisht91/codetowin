package com.piy.servicejaxb;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Bean {
	private String summary;
	private String description;
	
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
