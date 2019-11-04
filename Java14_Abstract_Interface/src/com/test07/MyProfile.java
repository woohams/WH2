package com.test07;

public class MyProfile extends Profile implements Display, Job {
	
	private String loc;
	
	public MyProfile(String name, String phone) {
		super(name, phone);
	}

	@Override
	public void jobLoc(String loc) {
		this.loc = loc;
	}
	@Override
	public void display() {
		super.getProfile();
		System.out.println("회사주소 : " + loc);
		System.out.println("회사직종 : " + JOB_ID);
	}

}
