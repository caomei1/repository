package ssm.dao.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ssm.entity.ReceivingAddress;
import ssm.entity.User;
import ssm.entity.Order;

public interface UserMapper {

	User findOneByUsername(String username);

	void create(User user);

	void updatePassword(@Param(value = "id") Integer id,@Param(value = "password") String password);

	void updateVip(User user);

	List<ReceivingAddress> findAllAddress(Integer id);

	void addAddress(ReceivingAddress address);

	void updateAddress(ReceivingAddress vipAddress);
	
	ReceivingAddress findOneIdAddress(int id);

	void deleteAddress(int id);

	List<Order> findAllOrder(int userId);

	Order Orderdetails(Integer id);

}
