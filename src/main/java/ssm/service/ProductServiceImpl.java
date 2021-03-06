package ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.dao.ProductDao;
import ssm.entity.Car;
import ssm.entity.Order;
import ssm.entity.Product;
import ssm.entity.ReceivingAddress;
import ssm.entity.User;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	//添加产品
	@Override
	public void addProduct(Product product) {
		productDao.addProduct(product);
	}

	//查询所有商品
	@Override
	public List<Product> findAllProduct() {
		return productDao.findAllProduct();
	}

	//通过id查询产品详情
	@Override
	public Product findOneProduct(Integer id) {
		return productDao.findOneProduct(id);
	}
	
	//商品详情页-增加购物车原有的商品数量
	@Override
	public void addOriginal(Integer userId, Integer productId, Integer quantity) {
		productDao.addOriginal(userId, productId, quantity);
	}
	
	//通过用户id查询地址
	@Override
	public List<ReceivingAddress> findAllAddress(Integer id) {
		return productDao.findAllAddress(id);
	}
	
	//增加地址
	@Override
	public void addAddress(ReceivingAddress address) {
		productDao.addAddress(address);
	}
	
	//通过用户id查询购物车
	@Override
	public List<Car> findAllCar(Integer id) {
		return productDao.findAllCar(id);
	}

	//商品添加到购物车
	@Override
	public void addToCart(Integer userId, Integer id) {
		productDao.addToCart(userId, id);
	}

	//通过购物车id删除商品
	@Override
	public void delete(Integer id) {
		productDao.delete(id);
	}
	
	//批量删除
	@Override
	public void batchDelete(List<Integer> productId, User user) {
		for (Integer productIds : productId) {
			productDao.batchDelete(productIds, user.getId());
		}
	}
	
	//显示提交订单页
	@Override
	public List<Order> findAllOrders(Integer id) {
		return productDao.findAllOrders(id);
	}

	//提交订单
	@Override
	public void createOrder(Integer userId, Integer addressId, 
			List<Integer> productId, Integer quantity) {		
		for (Integer productIds : productId) {
			Car car = productDao.findOneCar(userId, productIds);
			productDao.createOrder(userId, addressId, productIds, car.getQuantity());
		}
	}
	
	//通过用户id，商品id查询到指定商品
	@Override
	public Car findOneCar(Integer userId, Integer productId) {
		return productDao.findOneCar(userId, productId);
	}
	
	//增加数量
	@Override
	public void addNumber(Integer productId) {
		productDao.addNumber(productId);
	}

	//删除我的订单
	@Override
	public void deleteOrder(Integer id) {
		productDao.deleteOrder(id);
	}

	//减少购物车数量
	@Override
	public void reduceCarNumber(Integer id) {
		productDao.reduceCarNumber(id);
	}

	//增加购物车数量
	@Override
	public void addCarNumber(Integer id) {
		productDao.addCarNumber(id);
	}

	//通过购物车id查询商品
	@Override
	public Car findCarId(Integer id) {
		return productDao.findCarId(id);
	}

	//价格排序
	@Override
	public List<Product> findAllProductDesc() {
		return productDao.findAllProductDesc();
	}

	@Override
	public void addToAllCart(Integer userId, Integer productId, 
			Integer quantity) {
		productDao.addToAllCart(userId, productId, quantity);
	}

}
