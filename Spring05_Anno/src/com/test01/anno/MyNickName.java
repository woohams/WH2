package com.test01.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//<bean id ="nickName" class="com.test01.anno.NickName"/>
@Component
public class MyNickName {

	@Autowired
	private NickName nickName;
	
	public NickName getNickName() {
		return nickName;
	}
	
	public void setNickName(NickName nickName) {
		this.nickName = nickName;
	}
	
	public String toString() {
		return "나의 " + nickName;
	}
	
}
