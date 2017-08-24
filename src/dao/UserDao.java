package dao;

import java.util.List;

import vo.User;

public interface UserDao {
	int insert(User user);
	
	List<User> findAll();
	
}
