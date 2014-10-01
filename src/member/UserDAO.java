package member;

import java.util.List;
import platform.BaseDAO;

public class UserDAO extends BaseDAO<User> implements IUserDAO  {
	
	// ɾ��ָ���û�
	public boolean delete(Integer userID) {
		User userQuery = new User();
		userQuery.setUserID(userID);
		if (delete(userQuery))
			return true;
		return false;
	}
	
	// ɾ���û�
	public boolean deleteName(String userName) {
		User userQuery = new User();
		userQuery.setUserName(userName);
		if (delete(userQuery))
			return true;
		return false;
	}

	// ��ѯָ���û�
	public User select(Integer userID) {
		User userQuery = new User();
		userQuery.setUserID(userID);
		User user = select(userQuery).get(0);
		return user;
	}

	// ��ѯ�û�
	public User selectName(String userName) {
		User userQuery = new User();
		userQuery.setUserName(userName);
		User user = select(userQuery).get(0);
		return user;
	}

	// ��ѯ�����û�
	public List<User> findAll() {
		List<User> userList = selectAll("User");
		return userList;
	}

	
}