package com.SmartContactManager;

public class Contact {

	private int id;
	private String email;
	private String name;
	private String mobile_number;
	private String work;
	private String feed;
	public String getFeed() {
		return feed;
	}
	public void setFeed(String feed) {
		this.feed = feed;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public Contact(int id, String email, String name, String mobile_number, String work) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.mobile_number = mobile_number;
		this.work = work;
	}
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getParameter(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
