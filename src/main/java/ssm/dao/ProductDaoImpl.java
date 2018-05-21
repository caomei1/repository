package ssm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ssm.dao.mappers.ProductMapper;
import ssm.entity.Car;
import ssm.entity.Product;

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
	
}
