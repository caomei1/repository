package ssm.dao.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ssm.entity.Car;
import ssm.entity.Order;
import ssm.entity.Product;
import ssm.entity.ReceivingAddress;

public interface ProductMapper {

	void addProduct(Product product);

	List<Product> findAllProduct();

	Product findOneProduct(Integer id);
	
	void addOriginal(@Param(value="userId")Integer userId, 
			@Param(value="productId")Integer productId, 
			@Param(value="quantity")Integer quantity);
	
	List<ReceivingAddress> findAllAddress(Integer id);
	
	void addAddress(ReceivingAddress address);

	List<Car> findAllCar(Integer id);

	void addToCart(@Param(value="userId")Integer userId, 
			@Param(value="productId")Integer id);

	void delete(Integer id);
	
	void batchDelete(@Param(value="productId")Integer productIds, 
			@Param(value="userId") Integer userId);
	
	List<Order> findAllOrders(Integer id);

	void createOrder(@Param(value="userId")Integer userId, 
			@Param(value="addressId")Integer addressId, 
			@Param(value="productId")Integer productIds, 
			@Param(value="quantity")Integer quantity);
	
	Car findOneCar(@Param(value="userId")Integer userId, 
			@Param(value="productId")Integer productId);
	
	void addNumber(Integer productId);

	void deleteOrder(Integer id);

	void reduceCarNumber(Integer id);

	void addCarNumber(Integer id);

	Car findCarId(Integer id);

	List<Product> findAllProductDesc();

	void addToAllCart(@Param(value="userId")Integer userId, 
			@Param(value="productId")Integer productId, 
			@Param(value="quantity")Integer quantity);

}
