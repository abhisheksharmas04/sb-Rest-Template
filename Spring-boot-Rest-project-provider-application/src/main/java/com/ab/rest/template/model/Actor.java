package com.ab.rest.template.model;

public class Actor {
	
	private Integer aid;
	private String name;
	private Integer age;
	private String type;

	public Actor(Integer aid, String name, Integer age, String type) {
		this.aid = aid;
		this.name = name;
		this.age = age;
		this.type = type;
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
