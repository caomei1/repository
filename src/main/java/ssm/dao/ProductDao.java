package ssm.dao;

import java.util.List;

import ssm.entity.Car;
import ssm.entity.Order;
import ssm.entity.Product;
import ssm.entity.ReceivingAddress;

public interface ProductDao {

	void addProduct(Product product);

	List<Product> findAllProduct();

	Product findOneProduct(Integer id);
	
	List<ReceivingAddress> findAllAddress(Integer id);
	
	void addAddress(ReceivingAddress address);

	List<Car> findAllCar(Integer id);

	void addToCart(Integer userId, Integer id);

	void delete(Integer id);
	
	List<Order> findAllOrders(Integer id);

	void createOrder(Integer userId, Integer addressId, Integer productIds);

	void deleteProduct(Integer productIds);
	
	void deleteOrder(Integer id);
	
}
