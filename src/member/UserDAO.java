package member;

import java.util.List;
import platform.BaseDAO;
import platform.InterfaceDAOCommon;

public class UserDAO extends BaseDAO<User >implements InterfaceDAOCommon<User> {
	
	// ����û�
	public boolean insert(User user) {
		if (user != null) {
			this.getHibernateTemplate().save(user);
			return true;
		}
		return false;
	}
	
	// ɾ��ָ���û�
	public boolean delete(Integer userID) {
		User user = this.getHibernateTemplate().load(User.class, new Integer(userID));
		if (user != null) {
			this.getHibernateTemplate().delete(user);
			return true;
		}
		return false;
	}
	
	// ɾ���û�
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

	// ��ѯָ���û�
	public User find(Integer userID) {
		User user = (User) this.getHibernateTemplate().get(User.class,new Integer(userID));
		return user;
	}

	// ��ѯ�û�
	@SuppressWarnings("unchecked")
	public List<User> findUserData(String userName) {
		List<User> userList = this.getHibernateTemplate().find("from User user where user.userName=?",userName);
		return userList;
	}
	
	// ��ѯ�û�
	@SuppressWarnings("unchecked")
	public User findUser(String userName){
		List<User> userList = this.getHibernateTemplate().find("from User user where user.userName=?",userName);
		if (userList.size() == 1) {
			User user = userList.get(0); 
			return user;
		}
		return null;
	}

	// ��ѯ�����û�
	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		List<User> userList = this.getHibernateTemplate().find("from User");
		return userList;
	}

	// �����û�
	public boolean update(User user) {
		if (user != null) {
		this.getHibernateTemplate().update(user);
			return true;
		}
		return false;
	}
	
}