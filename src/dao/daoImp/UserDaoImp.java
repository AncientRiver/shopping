package dao.daoImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.UserDao;
import entity.JdbcUtil;
import vo.User;

public class UserDaoImp implements UserDao {
	
	JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
	@Override
	public int insert(User user) {
		// TODO Auto-generated method stub
		int num = 0;
		String sql = "insert into user values(?,?,?)";
		num = jdbcUtil.executeUpdate(sql, new Object[] { user.getUserAccount(), user.getPassword(),user.getNickname() });
		return num;
	}
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		List<User> all = new ArrayList<>();
		String sql = "select * from user";
		List<Object> list = jdbcUtil.executeQuery(sql,  null);
		for (int i = 0; i < list.size(); i++) {
			Object object = list.get(i);
			@SuppressWarnings("unchecked")
			Map<String, Object> map = (Map<String, Object>) object;
			User user = new User();
			user.setUserAccount((String) map.get("user"));
			user.setPassword((String) map.get("password"));
			user.setNickname((String) map.get("nickname"));
			all.add(user);
		}
		return all;
	}

}
