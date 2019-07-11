package com.zy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zy.model.User;
import com.zy.service.HelloService;


@RestController
public class ConsumerController {

	@Autowired
	HelloService helloService;
	
	@RequestMapping(value ="/ribbon-consumer", method = RequestMethod.GET)
	public String printConfig() {
		return helloService.hello();
	}
	
	@RequestMapping(value ="/ribbon-consumer1", method = RequestMethod.GET)
	public String hello1() {
		return helloService.hello1("aaaaaaaaaaaaaa");
	}
	
	@RequestMapping(value ="/ribbon-consumer2", method = RequestMethod.GET)
	public String hello2() {
		return helloService.hello2("aaaaaaaaaaaaaa","bbbbbb","55555555");
	}
	
	@RequestMapping(value ="/ribbon-consumer3", method = RequestMethod.POST)
	public String hello3() {
		User user = new User();
		user.setName("abasdasd");
		user.setEnglishName("englishName");
		user.setMobileNumber("77777777777");
		return helloService.hello3(user);
	}
	
	@RequestMapping(value ="/ribbon-consumer4", method = RequestMethod.GET)
	public String hello4() {
		return helloService.hello4("zhangyu");
	}
}
