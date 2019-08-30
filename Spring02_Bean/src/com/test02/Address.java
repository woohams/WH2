package com.test02;

public class Address {

	private String name;
	private String addr;
	private String tel;
	
	public Address() {
		
	}
	
	public Address(String name, String addr, String tel) {
		this.name = name;
		this.addr = addr;
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "이름은 " + name + "이고 주소는 " + addr + "이며 연락처는 " + tel + "이다.";
	}
	
	
	
}
