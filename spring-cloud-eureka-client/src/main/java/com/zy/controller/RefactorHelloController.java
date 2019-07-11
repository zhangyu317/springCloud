package com.zy.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.zhangyu.dto.UserInfo;
import com.zhangyu.service.HelloService;

@RestController
public class RefactorHelloController implements HelloService{

	@Override
	public String hello(@RequestParam String name) {
		return "hello " + name;
	}

	@Override
	public UserInfo hello(@RequestHeader String name, @RequestHeader String englishName, @RequestHeader String mobileNumber) {
		UserInfo user = new UserInfo();
		user.setName(name);
		user.setEnglishName(englishName);
		user.setMobileNumber(mobileNumber);
		return user;
	}

	@Override
	public String hello(@RequestBody UserInfo user) {
		return "hello "+user.getName()+", "+ user.getEnglishName() + ", "+ user.getMobileNumber();
	}
	
	
	
	
	
	
	
}
