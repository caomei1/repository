package ssm.dao;

import java.util.List;

import ssm.entity.Product;

public interface ProductDao {

	void addProduct(Product product);

	List<Product> findAllProduct();

	Product findOneProduct(Integer id);

}
