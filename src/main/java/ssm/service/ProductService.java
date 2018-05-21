package ssm.service;

import java.util.List;

import ssm.entity.Car;
import ssm.entity.Product;

public interface ProductService {

	void addProduct(Product product);

	List<Product> findAllProduct();

	Product findOneProduct(Integer id);

	List<Car> findAllCar(Integer id);

	void addToCart(Integer userId, Integer id);

	void delete(Integer id);

}
