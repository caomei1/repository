package ssm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ssm.entity.User;
import ssm.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	//登陆
	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public String login(@RequestParam(required = false) String error) {
		if (error != null) {
			System.out.println("登录失败");
		}
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/reg")
	public String register(@ModelAttribute User user) {
		return "reg";
	}

	//注册
	@RequestMapping(method = RequestMethod.POST, value = "/reg")
	public String create(@Valid @ModelAttribute User user, BindingResult bindingResult,
			 String password1, Model model) {
 // 表单bean封装
 // 使用@Valid进行校验，BindingResult获得校验结果，它们往往成对出现，并且要保证先后顺序
		System.out.println("添加用户: " + user);
		if (bindingResult.hasErrors()) {
			return "reg";
		} else if (!user.getPassword().equals(password1)) {
				model.addAttribute("error", "密码不一致");
				return "reg";
		} else {
				String encode = passwordEncoder.encode(user.getPassword());
				user.setPassword(encode);
				userService.create(user);
				return "redirect:/login";
		}
	}
	
}
