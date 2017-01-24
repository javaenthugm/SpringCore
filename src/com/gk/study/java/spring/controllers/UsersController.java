package com.gk.study.java.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gk.study.java.spring.services.UserServices;

@Controller
public class UsersController {

	@RequestMapping("/create")
	public String creatUser() {
		System.out.println("Inside the controller");
		return "createuser";
	}

	@RequestMapping(value = "/getUsers", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getUsers() {
		UserServices usrvs = new UserServices();
		//return "{\"a\":1, \"b\":\"foo\"}";
		return null;//usrvs.getAllUsers();
	}

}
