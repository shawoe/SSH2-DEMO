package member;

import java.util.List;

import platform.BaseService;

public class FriendService extends BaseService<Friend> {

	// ����ע������
	protected FriendDAO friendDAO;
	
	// ���Ӻ���
	public String addFriend(String friendName) {
		// ��ȡ��ǰ�û�
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// ��ȡ����
		Friend friend = friendDAO.findUserData(currentUser,friendName);
		if (friend != null)
			return INPUT;
		// ���Ӻ���
		friend = new Friend();
		friend.setFriendUser(currentUser);
		friend.setFriendTarget(friendName);
		friend.setFriendTime(getCurrentDate());
		// ��ѯ�໥����
		Friend friendMutual = friendDAO.findUserData(friendName,currentUser);
		if (friendMutual != null) {
			friend.setFriendMutual(true);
			friendMutual.setFriendMutual(true);
		} else {
			friend.setFriendMutual(false);
		}
		// �������ݿ�
		if (friendMutual!=null && !friendDAO.update(friendMutual))
			return ERROR;
		// �������ݿ�
		if (friendDAO.insert(friend))
			return SUCCESS;
		return ERROR;
	}

	// ɾ��ָ������
	public String deleteFriendByID(Integer friendID) {
		// ��ȡ��ǰ�û�
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// ��ȡָ������
		Friend friend = friendDAO.find(friendID);
		if (friend == null)
			return INPUT;
		if (friend.getFriendUser().equals(currentUser))
			return NONE;
		// ��ѯ�໥����
		Friend friendMutual;
		if (friend.getFriendMutual().equals("��")) {
			friendMutual = friendDAO.findUserData(friend.getFriendUser(), currentUser);
			friendMutual.setFriendMutual(false);
		}
		// �������ݿ�
		//if (friendMutual!=null && !friendDAO.update(friendMutual))
		//	return ERROR;
		if (friendDAO.delete(friendID))
			return SUCCESS;
		return ERROR;
	}

	// ɾ������
	public String deleteFriendByName(String friendName) {
		// ��ȡ��ǰ�û�
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// ��ȡ����
		Friend friend = friendDAO.findUserData(currentUser, friendName);
		if (friend == null)
			return INPUT;
		// ��ѯ�໥����
		Friend friendMutual;
		if (friend.getFriendMutual().equals("��")) {
			friendMutual = friendDAO.findUserData(friend.getFriendUser(), currentUser);
			friendMutual.setFriendMutual(false);
		}
		// �������ݿ�
		//if (friendMutual!=null && !friendDAO.update(friendMutual))
		//	return ERROR;
		if (friendDAO.deleteUserData(currentUser, friendName))
			return SUCCESS;
		return ERROR;
	}

	// ��ѯָ������
	public Friend getFriendByID(Integer friendID) {
		return friendDAO.find(friendID);
	}

	// ��ѯ����
	public Friend getFriendByName(String friendName) {
		// ��ȡ��ǰ�û�
		if (currentUser == null || currentUser.trim().length() == 0)
			return null;
		// ��ѯ����
		return friendDAO.findUserData(currentUser, friendName);
	}

	// ��ѯ���к���
	public List<Friend> getAllFriends() {
		// ��ȡ��ǰ�û�
		if (currentUser == null || currentUser.trim().length() == 0)
			return null;
		// ��ѯ���к���
		return friendDAO.findAll(currentUser);
	}

	// Ĭ������Getter/Setter
	public FriendDAO getFriendDAO() {
		return friendDAO;
	}

	public void setFriendDAO(FriendDAO friendDAO) {
		this.friendDAO = friendDAO;
	}

}
