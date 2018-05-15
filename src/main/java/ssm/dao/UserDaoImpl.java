package ssm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ssm.dao.mappers.UserMapper;
import ssm.entity.ReceivingAddress;
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

	@Override
	public void updateVip(User user) {
		userMapper.updateVip(user);
	}

	@Override
	public List<ReceivingAddress> findAllAddress(Integer id) {
		return userMapper.findAllAddress(id);
	}

	@Override
	public void addAddress(ReceivingAddress address) {
		userMapper.addAddress(address);
	}
	
}
