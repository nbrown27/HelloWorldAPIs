package com.nick.brown.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nick.brown.api.bean.RestAPIResponseBean;
import com.nick.brown.entity.User;
import com.nick.brown.exception.ValidationException;
import com.nick.brown.service.UserService;

@RestController
@EnableAutoConfiguration
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET, value="/users/getusers")
	public Page<User> getusers(Pageable pageable) {
		return userService.findAll(pageable);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/users/registeruser")
	public RestAPIResponseBean saveuser(@RequestBody User user, HttpServletResponse response) {
		RestAPIResponseBean bean = new RestAPIResponseBean();
		try {
			User savedUser = userService.save(user);
			bean.setStatus("200");
			bean.setMessage("success");
			bean.setData(savedUser);
		} catch (ValidationException ve) {
			bean.setStatus("400");
			bean.setMessage(ve.getMessage());
			response.setStatus(400);
		}
		return bean;
	}
}
