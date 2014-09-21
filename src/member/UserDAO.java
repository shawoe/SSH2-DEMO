package member;


import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;




public class UserDAO extends HibernateDaoSupport implements IUserDAO {
	
	// 填加用户
	public boolean insertUser(User user) {
		if (user != null) {
			this.getHibernateTemplate().save(user);
			return true;
		}
		return false;
	}
	
	// 删除指定用户
	public boolean deleteUserByID(Integer userID) {
		User user = this.getHibernateTemplate().load(User.class, new Integer(userID));
		if (user != null) {
			this.getHibernateTemplate().delete(user);
			return true;
		}
		return false;
	}
	
	// 删除用户
	@SuppressWarnings("unchecked")
	public boolean deleteUserByName(String userName) {
		List<User> userList = this.getHibernateTemplate().find("from User user where user.userName=?",userName);
		if (userList.size() == 1) {
			User user = userList.get(0); 
			this.getHibernateTemplate().delete(user);
			return true;
		}
		return false;
	}

	// 查询指定用户
	public User findUserByID(Integer userID) {
		User user = (User) this.getHibernateTemplate().get(User.class,new Integer(userID));
		return user;
	}

	// 查询用户
	@SuppressWarnings("unchecked")
	public User findUserByName(String userName) {
		List<User> userList = this.getHibernateTemplate().find("from User user where user.userName=?",userName);
		if (userList.size() == 1) {
			User user = userList.get(0); 
			return user;
		}
		return null;
	}

	// 查询所有用户
	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		List<User> userList = this.getHibernateTemplate().find("from User");
		return userList;
	}

	// 更新用户
	public boolean updateUser(User user) {
		if (user != null) {
		this.getHibernateTemplate().update(user);
			return true;
		}
		return false;
	}
	
}