package com.hello.mvc.model;

import org.springframework.stereotype.Repository;
//TODO :006. dao (@Repository)
@Repository
public class HelloDao {
	
	public String getHello() {
		//TODO :007.dao 에서 return "mvc"
		return "mvc";
		
	}

}
