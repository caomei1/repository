package ssm.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ssm.dao.UserDao;
import ssm.entity.ReceivingAddress;
import ssm.entity.User;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userDao.findOneByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		// 模拟从数据库查到的权限列表
		user.setPermissions(Arrays.asList("BOOK_RO", "CUSTOMER_RW"));
		UserDetailsImpl userDetailsImpl = new UserDetailsImpl(user);
		System.out.println("loadUserByUsername: " + userDetailsImpl);
		return userDetailsImpl;
	}

	//注册
	@Override
	public void create(User user) {
		userDao.create(user);
	}

	//修改密码
	@Override
	public void updatePassword(Integer id, String password) {
		userDao.updatePassword(id, password);
	}

	//修改vip信息
	@Override
	public void updateVip(User user) {
		userDao.updateVip(user);
	}

	@Override
	public List<ReceivingAddress> findAllAddress(Integer id) {
		return userDao.findAllAddress(id);
	}

	@Override
	public void addAddress(ReceivingAddress address) {
		userDao.addAddress(address);
	}

	@Override
	public void updateAddress(ReceivingAddress vipAddress) {
		userDao.updateAddress(vipAddress);
	}

	@Override
	public ReceivingAddress findOneIdAddress(int id) {
		return userDao.findOneIdAddress(id);
	}

	@Override
	public void deleteAddress(int id) {
		userDao.deleteAddress(id);
	}
}

class UserDetailsImpl extends org.springframework.security.core.userdetails.User {
	private User user;

	public UserDetailsImpl(User user) {
		super(user.getUsername(), user.getPassword(), buildAuthorities(user));
		this.user = user;
	}

	private static Collection<? extends GrantedAuthority> buildAuthorities(User user) {
		// spring security把角色权限都抽象成了GrantedAuthority，为了区分，我们使用PERM_前缀表示权限，ROLE_前缀表示角色
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (String permission : user.getPermissions()) {
			authorities.add(new SimpleGrantedAuthority("PERM_" + permission));
		}
		
		authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
		return authorities;
	}

	public User getUser() {
		return user;
	}

	@Override
	public String toString() {
		return "UserDetailsImpl [user=" + user + "]\n" + super.toString();
	}
	
	
}
