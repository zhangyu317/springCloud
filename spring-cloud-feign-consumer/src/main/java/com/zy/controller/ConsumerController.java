package com.zy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zhangyu.dto.UserInfo;
import com.zy.service.RefactorHelloService;


@RestController
public class ConsumerController {

	@Autowired
	RefactorHelloService refactorHelloService;
	
	/**
	 * 扩展
	 * @return
	 */
	@RequestMapping(value ="/feign-consumer4", method = RequestMethod.GET)
	public String hello4() {
		return refactorHelloService.hello("zhangsannnnnnnnnn");
	}
	
	@RequestMapping(value ="/feign-consumer5", method = RequestMethod.GET)
	public UserInfo hello5() {
		return refactorHelloService.hello("张禹2", "zack2", "18789797777777777");
	}
	
	@RequestMapping(value ="/feign-consumer6", method = RequestMethod.POST)
	public String hello6() {
		UserInfo user = new UserInfo();
		user.setName("李四四");
		user.setEnglishName("lisisi");
		user.setMobileNumber("111225255555555555");
		return refactorHelloService.hello(user);
	}
}
