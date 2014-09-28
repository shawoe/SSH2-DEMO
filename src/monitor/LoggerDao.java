package monitor;

import java.util.List;
import member.User;
import platform.BaseDAO;
import platform.InterfaceDAOCommon;

public class LoggerDAO extends BaseDAO<Logger> implements InterfaceDAOCommon<Logger> {
	
	// 查找日志
	@SuppressWarnings("unchecked")
	public List<Logger> findAll() {
		List<Logger> LoggerList = (List<Logger>) this.getHibernateTemplate().find("from Logger");
		return LoggerList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Logger> findUserData(String loggerUser) {
		List<Logger> LoggerList = (List<Logger>) this.getHibernateTemplate().find("from Logger logger where logger.operator=?",loggerUser);
		return LoggerList;
	}
	
	public Logger find(Integer loggerID) {
		Logger Logger = (Logger) this.getHibernateTemplate().get(Logger.class, new Integer(loggerID));
		return Logger;
	}

	// 增加日志
	public boolean insert(Logger logger) {
		if (logger != null) {
			this.getHibernateTemplate().saveOrUpdate(logger);
			return true;
		}
		return false;
	}

	// 更新日志
	public boolean update(Logger logger) {
		if (logger != null) {
			this.getHibernateTemplate().update(logger);
			return true;
		}
		return false;
	}

	// 删除日志
	public boolean delete(Integer loggerID) {
			Logger logger = getHibernateTemplate().load(Logger.class, new Integer(loggerID));
			if (logger != null) {
			getHibernateTemplate().delete(logger);
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteUserData(String userName) {
		List<User> userList = this.getHibernateTemplate().find("from User user where user.userName=?", userName);
		if (userList.size() >= 0) {
			User user = userList.get(0);
			this.getHibernateTemplate().delete(user);
			return true;
		}
		return false;
	}



}
