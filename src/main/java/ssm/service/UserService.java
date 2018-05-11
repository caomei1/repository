package ssm.service;

import ssm.entity.User;

public interface UserService {

	void create(User user);

	void updatePassword(Integer id, String password);

	void updateVip(User user);

}
