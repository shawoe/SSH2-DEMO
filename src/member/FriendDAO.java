package member;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import api.InterfaceDAO;

public class FriendDAO extends HibernateDaoSupport implements InterfaceDAO<Friend> {
	
	// 填加好友
	public boolean insert(Friend friend) {
		if (friend != null) {
			this.getHibernateTemplate().save(friend);
			return true;
		}
		return false;
	}
	
	// 删除指定好友
	public boolean delete(Integer friendID) {
		Friend friend = this.getHibernateTemplate().load(Friend.class, new Integer(friendID));
		if (friend != null) {
			this.getHibernateTemplate().delete(friend);
			return true;
		}
		return false;
	}
	
	// 删除好友
	@SuppressWarnings("unchecked")
	public boolean deleteDataByUserName(String friendUser, String friendTarget) {
		List<Friend> friendList = this.getHibernateTemplate().find("from Friend friend where friend.friendUser=? and friend.friendTarget=?", friendUser, friendTarget);
		if (friendList.size() == 1) {
			Friend friend = friendList.get(0); 
			this.getHibernateTemplate().delete(friend);
			return true;
		}
		return false;
	}

	// 查询指定好友
	public Friend find(Integer friendID) {
		Friend friend = (Friend) this.getHibernateTemplate().get(Friend.class,new Integer(friendID));
		return friend;
	}

	// 查询好友
	@SuppressWarnings("unchecked")
	public Friend findDataByUserName(String friendUser, String friendTarget) {
		List<Friend> friendList = this.getHibernateTemplate().find("from Friend friend where friend.friendUser=? and friend.friendTarget=?", friendUser, friendTarget);
		if (friendList.size() == 1) {
			Friend friend = friendList.get(0); 
			return friend;
		}
		return null;
	}

	// 查询所有好友
	@SuppressWarnings("unchecked")
	public List<Friend> findAll(String friendUser) {
		List<Friend> friendList = this.getHibernateTemplate().find("from Friendwhere friend.friendUser=?", friendUser);
		return friendList;
	}

	// 更新用户
	public boolean update(Friend friend) {
		if (friend != null) {
		this.getHibernateTemplate().update(friend);
			return true;
		}
		return false;
	}

	public boolean deleteDataByUserName(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Friend> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Friend> findDataByUserName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
}