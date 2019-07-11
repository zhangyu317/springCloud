package com.zy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zy.model.User;


@Service
public class HelloService {

	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="helloFallback")
	public String hello() {
		return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
	}
	
	@HystrixCommand(fallbackMethod="helloFallback")
	public String hello1(String name) {
		return restTemplate.getForEntity("http://HELLO-SERVICE/hello1?name={1}", String.class, name).getBody();
	}
	
	@HystrixCommand(fallbackMethod="helloFallback")
	public String hello2(String name, String englishName, String mobileNumber) {
		ResponseEntity<User> responseEntity = restTemplate.getForEntity("http://HELLO-SERVICE/hello2?name={1}&englishName={2}&mobileNumber={3}", User.class, name, englishName, mobileNumber);
		return responseEntity.getBody().toString();
	}
	
	@HystrixCommand(fallbackMethod="helloFallback")
	public String hello3(User user) {
		return restTemplate.postForEntity("http://HELLO-SERVICE/hello3", user, String.class).getBody();
	}
	
	@HystrixCommand(fallbackMethod="helloFallback")
	public String hello4(String name) {
		return restTemplate.getForEntity("http://HELLO-SERVICE/refactor/hello4?name={1}", String.class, name).getBody();
	}
	
	public String helloFallback() {
		return "error";
	}
	public String helloFallback(String name) {
		return "error";
	}
	public String helloFallback(String name, String englishName, String mobileNumber) {
//		User user = new User();
//		user.setName("error");
		return "error";
	}
	public String helloFallback(User user) {
		return "error";
	}
}
