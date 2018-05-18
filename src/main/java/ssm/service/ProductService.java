package ssm.service;

import java.util.List;

import ssm.entity.Product;

public interface ProductService {

	void addProduct(Product product);

	List<Product> findAllProduct();

	Product findOneProduct(Integer id);

}
