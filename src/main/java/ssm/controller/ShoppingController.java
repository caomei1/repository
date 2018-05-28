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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ssm.entity.Car;
import ssm.entity.Product;
import ssm.entity.ReceivingAddress;
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
	
	//添加产品
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
	
	//商品详情页多个数量加入购物车
	@RequestMapping(method = RequestMethod.GET, value = "/allTocar/{id}")
	public String addToCar1(@PathVariable Integer productId,
			@PathVariable Integer quantity, Model model, 
			@AuthenticationPrincipal(expression = "user") User user) {
		productService.allTocar(user.getId(), productId, quantity);
		model.addAttribute("Success","加入购物车成功");
		return "redirect:/car";
	}
	
	//购物车
	@RequestMapping(method = RequestMethod.GET, value = "/car")
	public String findCar(@AuthenticationPrincipal(expression="user") User user,
			Model model) {
		List<ReceivingAddress> address = productService.findAllAddress(user.getId());
		model.addAttribute("address", address);
		List<Car> cars = productService.findAllCar(user.getId());
		model.addAttribute("cars", cars);
		return "car";
	}
	
	//增加收货地址
	@RequestMapping(method = RequestMethod.POST, value = "/car")
	public String addAddress(@ModelAttribute ReceivingAddress address, 
			Model model, @AuthenticationPrincipal(expression = "user") User user){
		address.setUserId(user.getId());
		productService.addAddress(address);
		model.addAttribute("Success","添加收货地址成功");
		return "redirect:/car";
	}
	
	//商品加入购物车
	@RequestMapping(method = RequestMethod.GET, value = "/car/{id}")
	public String addToCar(@PathVariable Integer id, Model model, 
			@AuthenticationPrincipal(expression = "user") User user) {
		//查询到指定商品id
		Car car = productService.findOneCar(user.getId(), id);
		//判断商品 如果不存在则添加
		if(car == null){
			productService.addToCart(user.getId(), id);
			model.addAttribute("Success","加入购物车成功");
		} else {
			//存在就增加数量
			productService.addNumber(id);
		}
		return "redirect:/car";
	}
	
	//删除购物车订单
	@RequestMapping(method = RequestMethod.GET, value = "/delete/{id}")
	public String delete(@PathVariable Integer id) {
		productService.delete(id);
		return "redirect:/car";
	}
	
	//批量删除订单
	@RequestMapping(method = RequestMethod.POST, value = "/batchDelete")
	public String batchDelete(@RequestParam(name = "id") List<Integer> productId, 
			@AuthenticationPrincipal(expression = "user") User user) {
		productService.batchDelete(productId, user);
		return "redirect:/car";
	}
	
	//提交订单
	@RequestMapping(method = RequestMethod.POST, value = "/success")
	public String addAddress(@RequestParam Integer addressId, 
			@RequestParam(name = "id") List<Integer> id, 
			@RequestParam Integer quantity, Model model, 
			@AuthenticationPrincipal(expression = "user") User user){
		//订单创建
		productService.createOrder(user.getId(), addressId, id, quantity);
		//提交订单后清空购物车
		productService.batchDelete(id, user);
		model.addAttribute("Success","提交订单成功");
		return "redirect:/success";
	}
	
	//删除我的订单
	@RequestMapping(method = RequestMethod.GET, value = "/deleteOrder/{id}")
	public String deleteOrder(@PathVariable Integer id) {
		productService.deleteOrder(id);
		return "redirect:/vipOrder";
	}
	
	//通过商品id更新购物车数量
	@RequestMapping(method = RequestMethod.POST, value = "/updateCar")
	public String updateCartNumber(@PathVariable Integer productId, 
			@PathVariable Integer quantity) {
		productService.updateCartNumber(productId, quantity);
		return "car";
	}
	
	//减少购物车数量
	@RequestMapping(method = RequestMethod.GET, value = "/reduceCar")
	@ResponseBody
	public Car reduceCarNumber(@RequestParam Integer id) { 
		productService.reduceCarNumber(id);
		//通过购物车id查询
		Car car = productService.findCarId(id);
		return car;
	}
	
	//增加购物车数量
	@RequestMapping(method = RequestMethod.GET, value = "/addCar")
	@ResponseBody
	public Car addCarNumber(@RequestParam Integer id) {
		productService.addCarNumber(id);
		Car car = productService.findCarId(id);
		return car;
	}
	
}
