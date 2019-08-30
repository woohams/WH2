package com.test03;

import org.springframework.stereotype.Component;

@Component("samsong")
public class SamsongTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("SamsongTV power on");

	}

	@Override
	public void powerOff() {
		System.out.println("SamsongTV power off");

	}

	@Override
	public void volumUp() {
		System.out.println("SamsongTV volum up");

	}

	@Override
	public void volumDown() {
		System.out.println("SamsongTV volum down");

	}

}
