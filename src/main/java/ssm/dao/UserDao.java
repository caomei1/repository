package ssm.dao;

import java.util.List;

import ssm.entity.Order;
import ssm.entity.ReceivingAddress;
import ssm.entity.User;

public interface UserDao {
	
	User findOneByUsername(String username);

	void create(User user);

	void updatePassword(Integer id, String password);

	void updateVip(User user);

	List<ReceivingAddress> findAllAddress(Integer id);

	void addAddress(ReceivingAddress address);

	void updateAddress(ReceivingAddress vipAddress);
	
	ReceivingAddress findOneIdAddress(int id);

	void deleteAddress(int id);

	List<Order> findAllOrder(int id);

	Order Orderdetails(Integer id);

}
