package ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShoppingController {
	
	//商品列表页
	@RequestMapping(method = RequestMethod.GET, value = "/prolist")
	public String prolist() {
		return "prolist";
	}
	
	//商品详情页
	@RequestMapping(method = RequestMethod.GET, value = "/buyinfo")
	public String buyinfo() {
		return "buyinfo";
	}
	
	//购物车
	@RequestMapping(method = RequestMethod.GET, value = "/car")
	public String car() {
		return "car";
	}
	
	//订单确认页
	@RequestMapping(method = RequestMethod.GET, value = "/order")
	public String order() {
		return "order";
	}
	
	//订单成功创建页
	@RequestMapping(method = RequestMethod.GET, value = "/success")
	public String success() {
		return "success";
	}
}
