package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ssm.entity.Product;
import ssm.entity.User;
import ssm.service.ProductService;

@Controller
public class ShoppingController {
	
	@Autowired
	private ProductService productService;
	
	//商品上架页
	@RequestMapping(method = RequestMethod.GET, value = "/vip-product")
	public String product() {
		return "vip-product";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/vip-product")
	public String addProduct(@ModelAttribute Product product, Model model, 
			@AuthenticationPrincipal(expression = "user") User user) {
		product.setId(user.getId());
		productService.addProduct(product);
		model.addAttribute("Success","添加产品成功");
		return "redirect:/vip-product";
	}
	
	
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
