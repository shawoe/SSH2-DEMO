package member;

import java.util.List;

public class FriendService extends FriendServiceBase {

	// ���Ӻ���
	public String addFriend(String friendName) {
		// ��ȡ��ǰ�û�
		currentUser = sessionUtil.getSessionUser();
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// ��ȡ����
		friend = friendDAO.findFriendByName(currentUser,friendName);
		if (friend != null)
			return INPUT;
		// ���Ӻ���
		friend = new Friend();
		friend.setFriendUser(currentUser);
		friend.setFriendTarget(friendName);
		friend.setFriendTime(simpleDateFormat.format(date));
		// ��ѯ�໥����
		friendMutual = friendDAO.findFriendByName(friendName,currentUser);
		if (friendMutual != null) {
			friend.setFriendMutual(true);
			friendMutual.setFriendMutual(true);
		} else {
			friend.setFriendMutual(false);
		}
		// �������ݿ�
		if (friendMutual!=null && !friendDAO.updateFriend(friendMutual))
			return ERROR;
		// �������ݿ�
		if (friendDAO.insertFriend(friend))
			return SUCCESS;
		return ERROR;
	}

	// ɾ��ָ������
	public String deleteFriendByID(Integer friendID) {
		// ��ȡ��ǰ�û�
		currentUser = sessionUtil.getSessionUser();
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// ��ȡָ������
		friend = friendDAO.findFriendByID(friendID);
		if (friend == null)
			return INPUT;
		if (friend.getFriendUser().equals(currentUser))
			return NONE;
		// ��ѯ�໥����
		if (friend.getFriendMutual().equals("��")) {
			friendMutual = friendDAO.findFriendByName(friend.getFriendUser(), currentUser);
			friendMutual.setFriendMutual(false);
		}
		// �������ݿ�
		if (friendMutual!=null && !friendDAO.updateFriend(friendMutual))
			return ERROR;
		if (friendDAO.deleteFriendByID(friendID))
			return SUCCESS;
		return ERROR;
	}

	// ɾ������
	public String deleteFriendByName(String friendName) {
		// ��ȡ��ǰ�û�
		currentUser = sessionUtil.getSessionUser();
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// ��ȡ����
		friend = friendDAO.findFriendByName(currentUser, friendName);
		if (friend == null)
			return INPUT;
		// ��ѯ�໥����
		if (friend.getFriendMutual().equals("��")) {
			friendMutual = friendDAO.findFriendByName(friend.getFriendUser(), currentUser);
			friendMutual.setFriendMutual(false);
		}
		// �������ݿ�
		if (friendMutual!=null && !friendDAO.updateFriend(friendMutual))
			return ERROR;
		if (friendDAO.deleteFriendByName(currentUser, friendName))
			return SUCCESS;
		return ERROR;
	}

	// ��ѯָ������
	public Friend getFriendByID(Integer friendID) {
		return friendDAO.findFriendByID(friendID);
	}

	// ��ѯ����
	public Friend getFriendByName(String friendName) {
		// ��ȡ��ǰ�û�
		currentUser = sessionUtil.getSessionUser();
		if (currentUser == null || currentUser.trim().length() == 0)
			return null;
		// ��ѯ����
		return friendDAO.findFriendByName(currentUser, friendName);
	}

	// ��ѯ���к���
	public List<Friend> getAllFriends() {
		// ��ȡ��ǰ�û�
		currentUser = sessionUtil.getSessionUser();
		if (currentUser == null || currentUser.trim().length() == 0)
			return null;
		// ��ѯ���к���
		return friendDAO.findAllFriends(currentUser);
	}

}
