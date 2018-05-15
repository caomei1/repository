package ssm.service;

import java.util.List;

import ssm.entity.ReceivingAddress;
import ssm.entity.User;

public interface UserService {

	void create(User user);

	void updatePassword(Integer id, String password);

	void updateVip(User user);

	List<ReceivingAddress> findAllAddress(Integer id);

	void addAddress(ReceivingAddress address);

}
