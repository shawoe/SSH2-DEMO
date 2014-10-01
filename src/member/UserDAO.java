package member;

import java.util.List;
import platform.BaseDAO;

public class UserDAO extends BaseDAO<User> implements IUserDAO  {
	
	// 删除指定用户
	public boolean delete(Integer userID) {
		User userQuery = new User();
		userQuery.setUserID(userID);
		if (delete(userQuery))
			return true;
		return false;
	}
	
	// 删除用户
	public boolean deleteName(String userName) {
		User userQuery = new User();
		userQuery.setUserName(userName);
		if (delete(userQuery))
			return true;
		return false;
	}

	// 查询指定用户
	public User select(Integer userID) {
		User userQuery = new User();
		userQuery.setUserID(userID);
		User user = select(userQuery).get(0);
		return user;
	}

	// 查询用户
	public User selectName(String userName) {
		User userQuery = new User();
		userQuery.setUserName(userName);
		User user = select(userQuery).get(0);
		return user;
	}

	// 查询所有用户
	public List<User> findAll() {
		List<User> userList = selectAll("User");
		return userList;
	}

	
}