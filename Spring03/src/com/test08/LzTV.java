package com.test08;

public class LzTV implements TV {

	public LzTV() {
		System.out.println("Lz TV 생성!");
	}
	
	@Override
	public void powerOn() {
		System.out.println("Lz TV power on");


	}

	@Override
	public void powerOff() {
		System.out.println("Lz TV power off");

	}

	@Override
	public void volumUp() {
		System.out.println("Lz TV volum up");

	}

	@Override
	public void volumDown() {
		System.out.println("Lz TV volum down");
	}


}
