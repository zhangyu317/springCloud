package com.zy.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.zy.model.User;


@RestController
public class HelloController {
//	private final Logger logger =Logger.getLogger(getClass());
//	private static Logger logger = Logger.getLogger(TestController.class);
	
	@RequestMapping("/hello")
	public String printConfig() {
		System.out.println("Hello World!");
		return "hello world!";
	}
	
	@RequestMapping(value="/hello1",method=RequestMethod.GET)
	public String hello(@RequestParam String name) {
		return "hello " + name;
	}
	
	@RequestMapping(value="/hello2",method=RequestMethod.GET)
//	public User hello(@RequestHeader String name, @RequestHeader String englishName, @RequestHeader String mobileNumber) {
		public User hello(@RequestParam String name, @RequestParam String englishName, @RequestParam String mobileNumber) {
		User user = new User();
		user.setName(name);
		user.setEnglishName(englishName);
		user.setMobileNumber(mobileNumber);
		return user;
	}
	
	@RequestMapping(value="/hello3",method=RequestMethod.POST)
	public String hello(@RequestBody  User user) {
		return "hello "+user.getName()+", "+ user.getEnglishName() + ", "+ user.getMobileNumber();
	}
}
