package com.test03;

import org.springframework.stereotype.Component;

@Component
public class LzTV implements TV {

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
