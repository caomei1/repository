package ssm.dao.mappers;

import ssm.entity.User;

public interface UserMapper {

	User findOneByUsername(String username);

	void create(User user);

}
