package com.zy.service;

import org.springframework.cloud.openfeign.FeignClient;
import com.zhangyu.service.HelloService;

@FeignClient("hello-service")
public interface RefactorHelloService extends HelloService{
	
}
