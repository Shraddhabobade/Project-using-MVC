package com.tka.DemoMVC1.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.DemoMVC1.dao.User1Dao;
import com.tka.DemoMVC1.entity.User1;


@Service
public class UserService {
	
	@Autowired
	User1Dao dao;
	
	public String checkUser(User1 user) {
		String msg=null;
		User1 u= dao.checkUser(user);
		
		if(Objects.isNull(u)) {
			
			msg="Invalid User";
		}else {
			msg="Valid User";
		}
		return msg;
		
	}

}