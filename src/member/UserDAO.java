package member;

import java.util.List;
import platform.BaseDAO;
import platform.InterfaceDAOCommon;

public class UserDAO extends BaseDAO<User >implements InterfaceDAOCommon<User> {
	
	// 填加用户
	public boolean insert(User user) {
		if (user != null) {
			this.getHibernateTemplate().save(user);
			return true;
		}
		return false;
	}
	
	// 删除指定用户
	public boolean delete(Integer userID) {
		User user = this.getHibernateTemplate().load(User.class, new Integer(userID));
		if (user != null) {
			this.getHibernateTemplate().delete(user);
			return true;
		}
		return false;
	}
	
	// 删除用户
	@SuppressWarnings("unchecked")
	public boolean deleteUserData(String userName) {
		List<User> userList = this.getHibernateTemplate().find("from User user where user.userName=?",userName);
		if (userList.size() == 1) {
			User user = userList.get(0); 
			this.getHibernateTemplate().delete(user);
			return true;
		}
		return false;
	}

	// 查询指定用户
	public User find(Integer userID) {
		User user = (User) this.getHibernateTemplate().get(User.class,new Integer(userID));
		return user;
	}

	// 查询用户
	@SuppressWarnings("unchecked")
	public List<User> findUserData(String userName) {
		List<User> userList = this.getHibernateTemplate().find("from User user where user.userName=?",userName);
		return userList;
	}
	
	// 查询用户
	@SuppressWarnings("unchecked")
	public User findUser(String userName){
		List<User> userList = this.getHibernateTemplate().find("from User user where user.userName=?",userName);
		if (userList.size() == 1) {
			User user = userList.get(0); 
			return user;
		}
		return null;
	}

	// 查询所有用户
	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		List<User> userList = this.getHibernateTemplate().find("from User");
		return userList;
	}

	// 更新用户
	public boolean update(User user) {
		if (user != null) {
		this.getHibernateTemplate().update(user);
			return true;
		}
		return false;
	}
	
}