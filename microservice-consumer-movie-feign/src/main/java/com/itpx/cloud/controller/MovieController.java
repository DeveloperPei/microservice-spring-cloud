package com.itpx.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.itpx.cloud.UserFeignClient;
import com.itpx.cloud.entity.User;

@RestController
public class MovieController {
	@Autowired
	private UserFeignClient userFeignClient;
	
	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id){
		return userFeignClient.findById(id);
	}
	@GetMapping("/movie/post")  //消费者get请求调用服务提供者的post请求，服务者加入了@RequestBody注解
	public User postUser(User user){
		return userFeignClient.postUser(user);
	}
	//该请求没有成功，只要参数是复杂对象，即使指定了是get方法，feign依然会以post发送请求。
	@GetMapping("/movie/get")
	public User getUser(User user){
		return userFeignClient.getUser(user);
	}
}
