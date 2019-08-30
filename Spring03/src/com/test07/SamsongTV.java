package com.test07;

public class SamsongTV implements TV {

	public SamsongTV() {
		System.out.println("Samsong TV 생성!!");
		
	}
	
	@Override
	public void powerOn() {
		System.out.println("Samson TV power on");

	}

	@Override
	public void powerOff() {
		System.out.println("Samson TV power off");

	}

	@Override
	public void volumUp() {
		System.out.println("Samson TV volum up");

	}

	@Override
	public void volumDown() {
		System.out.println("Samson TV volum down");


	}

}
