package ssm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ssm.dao.mappers.ProductMapper;
import ssm.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	private ProductMapper productMapper;

	@Override
	public void addProduct(Product product) {
		productMapper.addProduct(product);
	}
	
}
