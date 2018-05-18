package ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.dao.ProductDao;
import ssm.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	//增加产品
	@Override
	public void addProduct(Product product) {
		productDao.addProduct(product);
	}

}
