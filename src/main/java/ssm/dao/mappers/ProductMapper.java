package ssm.dao.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ssm.entity.Car;
import ssm.entity.Product;

public interface ProductMapper {

	void addProduct(Product product);

	List<Product> findAllProduct();

	Product findOneProduct(Integer id);

	List<Car> findAllCar(Integer id);

	void addToCart(@Param(value="userId")Integer userId, @Param(value="productId")Integer id);

	void delete(Integer id);

}
