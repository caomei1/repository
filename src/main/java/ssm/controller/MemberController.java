package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ssm.entity.User;
import ssm.service.UserService;

@Controller
public class MemberController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	//会员中心 -个人信息
	@RequestMapping(method = RequestMethod.GET, value = "/vip")
	public String vip(@AuthenticationPrincipal(expression = "user") User user) {
		// @AuthenticationPrincipal默认拿到的是principal(UserDetailsImpl)，所以需要.user获得实体User对象（来自dao层）
		System.out.println("当前登录用户：" + user);
		return "vip";
	}
	
	//会员中心 -密码修改
	@RequestMapping(method = RequestMethod.GET, value = "/vipPwd")
	public String vipPwd(@AuthenticationPrincipal(expression = "user") User user) {
		System.out.println("当前登录用户：" + user);
		return "vipPwd";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/vipPwd")
	public String updatePassword(@RequestParam String password, 
			@AuthenticationPrincipal(expression = "user") User user, Model model){
		String encode = passwordEncoder.encode(password);
		userService.updatePassword(user.getId(), encode);
		System.out.println("update:" + encode);
		return "vipPwd";
	}
	
	//会员中心 -订单列表
	@RequestMapping(method = RequestMethod.GET, value = "/vipOrder")
	public String vipOrder() {
		return "vipOrder";
	}
	
	//会员中心 -订单详情
	@RequestMapping(method = RequestMethod.GET, value = "/vipXiaofei")
	public String vipXiaofei() {
		return "vipXiaofei";
	}
	
	//会员中心 -收货地址管理
	@RequestMapping(method = RequestMethod.GET, value = "/vipAddress")
	public String vipAddress() {
		return "vipAddress";
	}
}
