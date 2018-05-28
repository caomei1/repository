package ssm.service;

import java.util.List;

import ssm.entity.Car;
import ssm.entity.Order;
import ssm.entity.Product;
import ssm.entity.ReceivingAddress;
import ssm.entity.User;

public interface ProductService {

	void addProduct(Product product);

	List<Product> findAllProduct();

	Product findOneProduct(Integer id);
	
	void allTocar(Integer userId, Integer productId, Integer quantity);
	
	List<ReceivingAddress> findAllAddress(Integer id);
	
	void addAddress(ReceivingAddress address);

	List<Car> findAllCar(Integer id);
	
	void addToCart(Integer userId, Integer id);

	void delete(Integer id);
	
	void batchDelete(List<Integer> productId, User user);
	
	List<Order> findAllOrders(Integer id);

	void createOrder(Integer userId, Integer addressId, 
			List<Integer> productId, Integer quantity);
	
	Car findOneCar(Integer userId, Integer productId);

	void addNumber(Integer productId);
	
	void deleteOrder(Integer id);

	void updateCartNumber(Integer productId, Integer quantity);

	void reduceCarNumber(Integer id);

	void addCarNumber(Integer id);

	Car findCarId(Integer id);

}
