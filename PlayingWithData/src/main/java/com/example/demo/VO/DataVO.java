package com.example.demo.VO;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Component
public class DataVO {
	@Id
	private int no;
	private String name;
	private int age;
	private String sex;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
