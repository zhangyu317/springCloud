package com.zhangyu.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhangyu.dto.UserInfo;

@RequestMapping("/refactor")
public interface HelloService {
	
	@RequestMapping(value = "/hello4", method = RequestMethod.GET)
	String hello(@RequestParam("name") String name);
	
	@RequestMapping(value = "/hello5", method = RequestMethod.GET)
	UserInfo hello(@RequestHeader("name") String name, @RequestHeader("englishName") String englishName, @RequestHeader("mobileNumber") String mobileNumber);
	
	@RequestMapping(value = "/hello6", method = RequestMethod.POST)
	String hello(@RequestBody UserInfo user);
}
