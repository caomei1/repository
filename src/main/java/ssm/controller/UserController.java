package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ssm.entity.User;
import ssm.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public String login(@RequestParam(required = false) String error) {
		if (error != null) {
			System.out.println("登录失败");
		}
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/reg")
	public String register() {
		return "reg";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/reg")
	public String create(@ModelAttribute User user) {
		System.out.println("create user:  " + user);
		userService.create(user);
		System.out.println("created user: " + user);
		return "redirect:/login";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/prolist")
	public String prolist() {
		return "prolist";
	}

}
