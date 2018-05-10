package ssm.dao.mappers;

import org.apache.ibatis.annotations.Param;

import ssm.entity.User;

public interface UserMapper {

	User findOneByUsername(String username);

	void create(User user);

	void updatePassword(@Param(value = "id") Integer id,@Param(value = "password") String password);

}
