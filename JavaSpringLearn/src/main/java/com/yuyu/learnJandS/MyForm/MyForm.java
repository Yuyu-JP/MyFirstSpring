package com.yuyu.learnJandS.MyForm;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class MyForm {
	
	@NotNull
	@Size(min = 2, max = 30)
	private String name;
	
	@NotNull
	@Min(18)
	private int age;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "MyForm [name=" + name + ", age=" + age + "]";
	}
}

