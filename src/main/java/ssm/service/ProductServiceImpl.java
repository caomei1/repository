package ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.dao.ProductDao;
import ssm.entity.Car;
import ssm.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	//增加产品
	@Override
	public void addProduct(Product product) {
		productDao.addProduct(product);
	}

	//查询所有产品
	@Override
	public List<Product> findAllProduct() {
		return productDao.findAllProduct();
	}

	//通过id查询产品详情
	@Override
	public Product findOneProduct(Integer id) {
		return productDao.findOneProduct(id);
	}
	
	//通过用户id查询购物车
	@Override
	public List<Car> findAllCar(Integer id) {
		return productDao.findAllCar(id);
	}

	//直接添加到购物车
	@Override
	public void addToCart(Integer userId, Integer id) {
		productDao.addToCart(userId, id);
	}

}
