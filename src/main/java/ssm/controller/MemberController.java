package ssm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ssm.entity.Order;
import ssm.entity.ReceivingAddress;
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
	public String vip(
			@AuthenticationPrincipal(expression = "user") User user) {
		// @AuthenticationPrincipal默认拿到的是principal(UserDetailsImpl)，所以需要.user获得实体User对象（来自dao层）
		System.out.println("当前登录用户：" + user);
		return "vip";
	}
	
	//修改个人信息
	@RequestMapping(method = RequestMethod.POST, value = "/vip")
	public String updateVip(@ModelAttribute User user, 
			@AuthenticationPrincipal(expression = "user") User user1) {
		//user是表单提交的,user1是登录的
		user.setId(user1.getId());
		//把我登录的id设进表单，得到要改的id
		userService.updateVip(user);
		return "vip";
	}
	
	//会员中心 -密码修改
	@RequestMapping(method = RequestMethod.GET, value = "/vipPwd")
	public String vipPwd(@ModelAttribute User user, 
			@AuthenticationPrincipal(expression = "user") User user1) {
		System.out.println("当前登录用户：" + user1);
		return "vipPwd";
	}
	
	//修改密码
	@RequestMapping(method = RequestMethod.POST, value = "/vipPwd")
	public String updatePassword(
			@Valid @ModelAttribute User user, BindingResult bindingResult, 
			@RequestParam String password1, 
			@AuthenticationPrincipal(expression = "user") User user1){
		
		if (bindingResult.hasErrors()) {
				return "vipPwd";
		} else if (!user.getPassword().equals(password1)) {
				bindingResult.rejectValue("password", "error", "密码不一致");
//				model.addAttribute("error", "修改失败，密码不一致");
				return "vipPwd";
		} else {
				String encode = passwordEncoder.encode(password1);
				userService.updatePassword(user1.getId(), encode);
				System.out.println("update:" + encode);
				return "vip";
		}
	}
	
	//会员中心 -订单列表
	@RequestMapping(method = RequestMethod.GET, value = "/vipOrder")
	public String vipOrder(
			@AuthenticationPrincipal(expression = "user") User user, 
			Model model) {
		List<Order> orders = userService.findAllOrder(user.getId());
		model.addAttribute("orders", orders);
		return "vipOrder";
	}
	
	//会员中心 -订单详情
	@RequestMapping(method = RequestMethod.GET, value = "/vipXiaofei")
	public String vipXiaofei() {
		return "vipXiaofei";
	}
	
	//会员中心 -收货地址详情
	@RequestMapping(method = RequestMethod.GET, value = "/vipAddress")
	public String vipAddress(@AuthenticationPrincipal(expression = "user") User user, 
			Model model) {
		List<ReceivingAddress> vipAddress = userService.findAllAddress(user.getId());
		model.addAttribute("vipAddress", vipAddress);
		return "vipAddress";
	}
	
	//增加收货地址
	@RequestMapping(method = RequestMethod.POST, value = "/vipAddress")
	public String addAddress(@ModelAttribute ReceivingAddress address, 
			Model model, @AuthenticationPrincipal(expression = "user") User user){
		address.setUserId(user.getId());
		userService.addAddress(address);
		model.addAttribute("Success","添加收货地址成功");
		return "redirect:/vipAddress";
	}
	
	//修改收货地址
	@RequestMapping(method = RequestMethod.GET, value = "/vipAddress/{id}/updateVipAddress")
	public String findOneIdAddress(@PathVariable int id, Model model) {
		ReceivingAddress address = userService.findOneIdAddress(id);
		model.addAttribute("address", address);
		return "updateVipAddress";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/vipAddress/{id}/updateVipAddress")
	public String updateAddress(@ModelAttribute ReceivingAddress vipAddress, 
			@PathVariable int id) {
		vipAddress.setId(id);
		userService.updateAddress(vipAddress);	
		return "redirect:/vipAddress";
	}
	
	//删除收货地址
	@RequestMapping(method = RequestMethod.GET, value = "/vipAddress/{id}")
	public String deleteAddress(@PathVariable int id) {
		userService.deleteAddress(id);
		return "redirect:/vipAddress";
	}
	
}
