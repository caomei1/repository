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
	public void allTocar(Integer userId, Integer productId, Integer quantity) {
		productMapper.allTocar(userId, productId, quantity);
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
	public void batchDelete(Integer productIds) {
		productMapper.batchDelete(productIds);
	}

	@Override
	public List<Order> findAllOrders(Integer id) {
		return productMapper.findAllOrders(id);
	}

	@Override
	public void createOrder(Integer userId, Integer addressId, Integer productIds) {
		productMapper.createOrder(userId, addressId, productIds);
	}
	
	@Override
	public Car findOneCar(Integer userId, Integer productId) {
		return productMapper.findOneCar(userId, productId);
	}

	@Override
	public void addNumber(Integer userId, Integer productId) {
		productMapper.addNumber(userId, productId);
	}
	
	@Override
	public void deleteProduct(Integer productIds) {
		productMapper.deleteProduct(productIds);
	}

	@Override
	public void deleteOrder(Integer id) {
		productMapper.deleteOrder(id);
	}

}
