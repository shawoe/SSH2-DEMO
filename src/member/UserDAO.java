package member;


import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;




public class UserDAO extends HibernateDaoSupport implements IUserDAO {
	
	// ����û�
	public boolean insertUser(User user) {
		if (user != null) {
			this.getHibernateTemplate().save(user);
			return true;
		}
		return false;
	}
	
	// ɾ��ָ���û�
	public boolean deleteUserByID(Integer userID) {
		User user = this.getHibernateTemplate().load(User.class, new Integer(userID));
		if (user != null) {
			this.getHibernateTemplate().delete(user);
			return true;
		}
		return false;
	}
	
	// ɾ���û�
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

	// ��ѯָ���û�
	public User findUserByID(Integer userID) {
		User user = (User) this.getHibernateTemplate().get(User.class,new Integer(userID));
		return user;
	}

	// ��ѯ�û�
	@SuppressWarnings("unchecked")
	public User findUserByName(String userName) {
		List<User> userList = this.getHibernateTemplate().find("from User user where user.userName=?",userName);
		if (userList.size() == 1) {
			User user = userList.get(0); 
			return user;
		}
		return null;
	}

	// ��ѯ�����û�
	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		List<User> userList = this.getHibernateTemplate().find("from User");
		return userList;
	}

	// �����û�
	public boolean updateUser(User user) {
		if (user != null) {
		this.getHibernateTemplate().update(user);
			return true;
		}
		return false;
	}
	
}