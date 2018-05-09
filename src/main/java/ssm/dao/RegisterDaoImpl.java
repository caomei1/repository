package ssm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ssm.dao.mappers.RegisterMapper;
import ssm.entity.User;

@Repository
public class RegisterDaoImpl implements RegisterDao {
	
	@Autowired
	private RegisterMapper registerMapper;

	@Override
	public void create(User user) {
		registerMapper.create(user);
	}

}
