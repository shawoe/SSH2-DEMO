package member;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class FriendDAO extends HibernateDaoSupport {
	
	// 填加好友
	public boolean insertFriend(Friend friend) {
		if (friend != null) {
			this.getHibernateTemplate().save(friend);
			return true;
		}
		return false;
	}
	
	// 删除指定好友
	public boolean deleteFriendByID(Integer friendID) {
		Friend friend = this.getHibernateTemplate().load(Friend.class, new Integer(friendID));
		if (friend != null) {
			this.getHibernateTemplate().delete(friend);
			return true;
		}
		return false;
	}
	
	// 删除好友
	@SuppressWarnings("unchecked")
	public boolean deleteFriendByName(String friendUser, String friendTarget) {
		List<Friend> friendList = this.getHibernateTemplate().find("from Friend friend where friend.friendUser=? and friend.friendTarget=?", friendUser, friendTarget);
		if (friendList.size() == 1) {
			Friend friend = friendList.get(0); 
			this.getHibernateTemplate().delete(friend);
			return true;
		}
		return false;
	}

	// 查询指定好友
	public Friend findFriendByID(Integer friendID) {
		Friend friend = (Friend) this.getHibernateTemplate().get(Friend.class,new Integer(friendID));
		return friend;
	}

	// 查询好友
	@SuppressWarnings("unchecked")
	public Friend findFriendByName(String friendUser, String friendTarget) {
		List<Friend> friendList = this.getHibernateTemplate().find("from Friend friend where friend.friendUser=? and friend.friendTarget=?", friendUser, friendTarget);
		if (friendList.size() == 1) {
			Friend friend = friendList.get(0); 
			return friend;
		}
		return null;
	}

	// 查询所有好友
	@SuppressWarnings("unchecked")
	public List<Friend> findAllFriends(String friendUser) {
		List<Friend> friendList = this.getHibernateTemplate().find("from Friendwhere friend.friendUser=?", friendUser);
		return friendList;
	}

	// 更新用户
	public boolean updateFriend(Friend friend) {
		if (friend != null) {
		this.getHibernateTemplate().update(friend);
			return true;
		}
		return false;
	}
	
}