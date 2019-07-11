package com.zy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zy.model.User;

@RestController
@RefreshScope
public class ConfigController {
	
	@Value("${name}")
	String name;
	
	@Value("${englishName}")
	String englishName;
	
	@Value("${mobileNumber}")
	String mobileNumber;
	
	@RequestMapping("/information")
	public User printConfig() {
		User user = new User();
		user.setName(name);
		user.setEnglishName(englishName);
		user.setMobileNumber(mobileNumber);
		return user;
	}
	
}
