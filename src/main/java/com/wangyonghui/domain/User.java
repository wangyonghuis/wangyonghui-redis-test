package com.wangyonghui.domain;

import java.io.Serializable;

public class User implements Serializable{
	//2.	编写User类，共有ID，姓名，性别，手机，邮箱，生日，共6个属性。
	private int id;
	private String name;
	private String sex;
	private String phone;
	private String Email;
	private String briday;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
	public String getBriday() {
		return briday;
	}
	public void setBriday(String briday) {
		this.briday = briday;
	}
	
	public User() {
		super();
	}
	public User(int id, String name, String sex, String phone, String Email,
			String briday) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		Email = Email;
		this.briday = briday;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", sex=" + sex + ", phone="
				+ phone + ", Email=" + Email + ", briday=" + briday + "]";
	}
	
	
	
	
	
}
