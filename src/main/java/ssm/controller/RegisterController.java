package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ssm.entity.User;
import ssm.service.RegisterService;

@Controller
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;

	@RequestMapping(method = RequestMethod.POST, value = "/reg")
	@ResponseBody
	public User create(@RequestBody User user) {
		System.out.println("create user:  " + user);
		registerService.create(user);
		System.out.println("created user: " + user);
		return user;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/reg")
	public String register() {
		return "reg";
	}

}
