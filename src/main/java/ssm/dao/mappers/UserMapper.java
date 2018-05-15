package ssm.dao.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ssm.entity.ReceivingAddress;
import ssm.entity.User;

public interface UserMapper {

	User findOneByUsername(String username);

	void create(User user);

	void updatePassword(@Param(value = "id") Integer id,@Param(value = "password") String password);

	void updateVip(User user);

	List<ReceivingAddress> findAllAddress(Integer id);

	void addAddress(ReceivingAddress address);

}
