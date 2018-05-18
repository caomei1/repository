package ssm.dao.mappers;

import java.util.List;

import ssm.entity.Product;

public interface ProductMapper {

	void addProduct(Product product);

	List<Product> findAllProduct();

	Product findOneProduct(Integer id);

}
