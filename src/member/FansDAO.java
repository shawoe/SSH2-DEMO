package member;

import java.util.List;
import platform.BaseDAO;
import platform.InterfaceDAO;

public class FansDAO extends BaseDAO<Fans> implements InterfaceDAO<Fans> {
	
	// 填加好友
	public boolean insert(Fans fans) {
		if (fans != null) {
			this.getHibernateTemplate().save(fans);
			return true;
		}
		return false;
	}
	
	// 删除指定好友
	public boolean delete(Integer fansID) {
		Fans fans = this.getHibernateTemplate().load(Fans.class, new Integer(fansID));
		if (fans != null) {
			this.getHibernateTemplate().delete(fans);
			return true;
		}
		return false;
	}
	
	// 删除好友
	@SuppressWarnings("unchecked")
	public boolean deleteUserData(String fansUser, String fansTarget) {
		List<Fans> fansList = this.getHibernateTemplate().find("from Fans fans where fans.fansUser=? and fans.fansTarget=?", fansUser, fansTarget);
		if (fansList.size() == 1) {
			Fans fans = fansList.get(0); 
			this.getHibernateTemplate().delete(fans);
			return true;
		}
		return false;
	}

	// 查询指定好友
	public Fans select(Integer fansID) {
		Fans fans = (Fans) this.getHibernateTemplate().get(Fans.class,new Integer(fansID));
		return fans;
	}

	// 查询好友
	@SuppressWarnings("unchecked")
	public Fans selectUserData(String fansUser, String fansTarget) {
		List<Fans> fansList = this.getHibernateTemplate().find("from Fans fans where fans.fansUser=? and fans.fansTarget=?", fansUser, fansTarget);
		if (fansList.size() == 1) {
			Fans fans = fansList.get(0); 
			return fans;
		}
		return null;
	}

	// 查询所有好友
	@SuppressWarnings("unchecked")
	public List<Fans> selectAll(String fansUser) {
		List<Fans> fansList = this.getHibernateTemplate().find("from Fanswhere fans.fansUser=?", fansUser);
		return fansList;
	}

	// 更新用户
	public boolean update(Fans fans) {
		if (fans != null) {
		this.getHibernateTemplate().update(fans);
			return true;
		}
		return false;
	}

	public boolean deleteUserData(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Fans> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Fans> selectUserData(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
}