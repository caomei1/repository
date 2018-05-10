package ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	//会员中心 -个人信息
	@RequestMapping(method = RequestMethod.GET, value = "/vip")
	public String vip() {
		return "vip";
	}
	
	//会员中心 -密码修改
	@RequestMapping(method = RequestMethod.GET, value = "/vipPwd")
	public String vipPwd() {
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
