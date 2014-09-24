package member;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import api.InterfaceDAO;

public class FriendDAO extends HibernateDaoSupport implements InterfaceDAO<Friend> {
	
	// ��Ӻ���
	public boolean insert(Friend friend) {
		if (friend != null) {
			this.getHibernateTemplate().save(friend);
			return true;
		}
		return false;
	}
	
	// ɾ��ָ������
	public boolean delete(Integer friendID) {
		Friend friend = this.getHibernateTemplate().load(Friend.class, new Integer(friendID));
		if (friend != null) {
			this.getHibernateTemplate().delete(friend);
			return true;
		}
		return false;
	}
	
	// ɾ������
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

	// ��ѯָ������
	public Friend find(Integer friendID) {
		Friend friend = (Friend) this.getHibernateTemplate().get(Friend.class,new Integer(friendID));
		return friend;
	}

	// ��ѯ����
	@SuppressWarnings("unchecked")
	public Friend findDataByUserName(String friendUser, String friendTarget) {
		List<Friend> friendList = this.getHibernateTemplate().find("from Friend friend where friend.friendUser=? and friend.friendTarget=?", friendUser, friendTarget);
		if (friendList.size() == 1) {
			Friend friend = friendList.get(0); 
			return friend;
		}
		return null;
	}

	// ��ѯ���к���
	@SuppressWarnings("unchecked")
	public List<Friend> findAll(String friendUser) {
		List<Friend> friendList = this.getHibernateTemplate().find("from Friendwhere friend.friendUser=?", friendUser);
		return friendList;
	}

	// �����û�
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