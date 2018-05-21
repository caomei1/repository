package ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ssm.entity.Car;
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
	public String prolist(@ModelAttribute Product product, Model model) {
		List<Product> proList = productService.findAllProduct();
		model.addAttribute("proList", proList);
		return "prolist";
	}
	
	//商品详情页
	@RequestMapping(method = RequestMethod.GET, value = "/buyinfo/{id}")
	public String buyinfo(@PathVariable Integer id, Model model) {
		Product proOne = productService.findOneProduct(id);
		model.addAttribute("proOne", proOne);
		return "buyinfo";
	}
	
	//购物车
	@RequestMapping(method = RequestMethod.GET, value = "/car")
	public String findCar(@AuthenticationPrincipal(expression="user") User user,
			Model model) {
/*		List<ReceivingAddress> address = productService.findAllAddress(user.getId());
		model.addAttribute("address", address);*/
		List<Car> products = productService.findAllCar(user.getId());
		model.addAttribute("products", products);
		return "car";
	}
	
	//商品直接加入购物车
	@RequestMapping(method = RequestMethod.GET, value = "/car/{id}")
	public String addToCar(@PathVariable Integer id, Model model, 
			@AuthenticationPrincipal(expression = "user") User user){
		productService.addToCart(user.getId(),id);
		model.addAttribute("Success","加入购物车成功");
		return "redirect:/car";
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
