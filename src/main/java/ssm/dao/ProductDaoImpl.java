package ssm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ssm.dao.mappers.ProductMapper;
import ssm.entity.Car;
import ssm.entity.Order;
import ssm.entity.Product;
import ssm.entity.ReceivingAddress;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	private ProductMapper productMapper;

	@Override
	public void addProduct(Product product) {
		productMapper.addProduct(product);
	}

	@Override
	public List<Product> findAllProduct() {
		return productMapper.findAllProduct();
	}

	@Override
	public Product findOneProduct(Integer id) {
		return productMapper.findOneProduct(id);
	}
	
	@Override
	public void addOriginal(Integer userId, Integer productId, Integer quantity) {
		productMapper.addOriginal(userId, productId, quantity);
	}
	
	@Override
	public List<ReceivingAddress> findAllAddress(Integer id) {
		return productMapper.findAllAddress(id);
	}
	
	@Override
	public void addAddress(ReceivingAddress address) {
		productMapper.addAddress(address);
	}

	@Override
	public List<Car> findAllCar(Integer id) {
		return productMapper.findAllCar(id);
	}

	@Override
	public void addToCart(Integer userId, Integer id) {
		productMapper.addToCart(userId, id);
	}

	@Override
	public void delete(Integer id) {
		productMapper.delete(id);
	}
	
	@Override
	public void batchDelete(Integer productIds, Integer userId) {
		productMapper.batchDelete(productIds, userId);
	}

	@Override
	public List<Order> findAllOrders(Integer id) {
		return productMapper.findAllOrders(id);
	}

	@Override
	public void createOrder(Integer userId, Integer addressId, 
			Integer productIds, Integer quantity) {
		productMapper.createOrder(userId, addressId, productIds, quantity);
	}
	
	@Override
	public Car findOneCar(Integer userId, Integer productId) {
		return productMapper.findOneCar(userId, productId);
	}

	@Override
	public void addNumber(Integer productId) {
		productMapper.addNumber(productId);
	}

	@Override
	public void deleteOrder(Integer id) {
		productMapper.deleteOrder(id);
	}

	@Override
	public void reduceCarNumber(Integer id) {
		productMapper.reduceCarNumber(id);
	}

	@Override
	public void addCarNumber(Integer id) {
		productMapper.addCarNumber(id);
	}

	@Override
	public Car findCarId(Integer id) {
		return productMapper.findCarId(id);
	}

	@Override
	public List<Product> findAllProductDesc() {
		return productMapper.findAllProductDesc();
	}

	@Override
	public void addToAllCart(Integer userId, Integer productId, 
			Integer quantity) {
		productMapper.addToAllCart(userId, productId, quantity);
	}

}
