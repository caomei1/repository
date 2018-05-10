package ssm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import ssm.dao.mappers.UserMapper;
import ssm.entity.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User findOneByUsername(String username) {
		return userMapper.findOneByUsername(username);
	}

	@Override
	public void create(User user) {
		userMapper.create(user);
		System.out.println("after registerMapperImpl.create: " + user);
	}

	@Override
	public void updatePassword(Integer id, String password) {
		userMapper.updatePassword(id, password);
	}
	
}
