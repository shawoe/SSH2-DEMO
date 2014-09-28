package member;

import java.util.List;

import platform.BaseService;

public class FriendService extends BaseService<Friend> {

	// 依赖注入属性
	protected FriendDAO friendDAO;
	
	// 增加好友
	public String addFriend(String friendName) {
		// 获取当前用户
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// 获取好友
		Friend friend = friendDAO.findUserData(currentUser,friendName);
		if (friend != null)
			return INPUT;
		// 增加好友
		friend = new Friend();
		friend.setFriendUser(currentUser);
		friend.setFriendTarget(friendName);
		friend.setFriendTime(getCurrentDate());
		// 查询相互好友
		Friend friendMutual = friendDAO.findUserData(friendName,currentUser);
		if (friendMutual != null) {
			friend.setFriendMutual(true);
			friendMutual.setFriendMutual(true);
		} else {
			friend.setFriendMutual(false);
		}
		// 更新数据库
		if (friendMutual!=null && !friendDAO.update(friendMutual))
			return ERROR;
		// 存至数据库
		if (friendDAO.insert(friend))
			return SUCCESS;
		return ERROR;
	}

	// 删除指定好友
	public String deleteFriendByID(Integer friendID) {
		// 获取当前用户
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// 获取指定好友
		Friend friend = friendDAO.find(friendID);
		if (friend == null)
			return INPUT;
		if (friend.getFriendUser().equals(currentUser))
			return NONE;
		// 查询相互好友
		Friend friendMutual;
		if (friend.getFriendMutual().equals("是")) {
			friendMutual = friendDAO.findUserData(friend.getFriendUser(), currentUser);
			friendMutual.setFriendMutual(false);
		}
		// 更新数据库
		//if (friendMutual!=null && !friendDAO.update(friendMutual))
		//	return ERROR;
		if (friendDAO.delete(friendID))
			return SUCCESS;
		return ERROR;
	}

	// 删除好友
	public String deleteFriendByName(String friendName) {
		// 获取当前用户
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// 获取好友
		Friend friend = friendDAO.findUserData(currentUser, friendName);
		if (friend == null)
			return INPUT;
		// 查询相互好友
		Friend friendMutual;
		if (friend.getFriendMutual().equals("是")) {
			friendMutual = friendDAO.findUserData(friend.getFriendUser(), currentUser);
			friendMutual.setFriendMutual(false);
		}
		// 更新数据库
		//if (friendMutual!=null && !friendDAO.update(friendMutual))
		//	return ERROR;
		if (friendDAO.deleteUserData(currentUser, friendName))
			return SUCCESS;
		return ERROR;
	}

	// 查询指定好友
	public Friend getFriendByID(Integer friendID) {
		return friendDAO.find(friendID);
	}

	// 查询好友
	public Friend getFriendByName(String friendName) {
		// 获取当前用户
		if (currentUser == null || currentUser.trim().length() == 0)
			return null;
		// 查询好友
		return friendDAO.findUserData(currentUser, friendName);
	}

	// 查询所有好友
	public List<Friend> getAllFriends() {
		// 获取当前用户
		if (currentUser == null || currentUser.trim().length() == 0)
			return null;
		// 查询所有好友
		return friendDAO.findAll(currentUser);
	}

	// 默认属性Getter/Setter
	public FriendDAO getFriendDAO() {
		return friendDAO;
	}

	public void setFriendDAO(FriendDAO friendDAO) {
		this.friendDAO = friendDAO;
	}

}
