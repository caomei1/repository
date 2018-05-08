package ssm.dao.mappers;

import ssm.entity.User;

public interface UserMapper {

	User findOneByUsername(String username);

}
