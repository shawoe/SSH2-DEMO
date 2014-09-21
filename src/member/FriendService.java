package member;

import java.util.List;

public class FriendService extends FriendServiceBase {

	// 增加好友
	public String addFriend(String friendName) {
		// 获取当前用户
		currentUser = sessionUtil.getSessionUser();
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// 获取好友
		friend = friendDAO.findFriendByName(currentUser,friendName);
		if (friend != null)
			return INPUT;
		// 增加好友
		friend = new Friend();
		friend.setFriendUser(currentUser);
		friend.setFriendTarget(friendName);
		friend.setFriendTime(simpleDateFormat.format(date));
		// 查询相互好友
		friendMutual = friendDAO.findFriendByName(friendName,currentUser);
		if (friendMutual != null) {
			friend.setFriendMutual(true);
			friendMutual.setFriendMutual(true);
		} else {
			friend.setFriendMutual(false);
		}
		// 更新数据库
		if (friendMutual!=null && !friendDAO.updateFriend(friendMutual))
			return ERROR;
		// 存至数据库
		if (friendDAO.insertFriend(friend))
			return SUCCESS;
		return ERROR;
	}

	// 删除指定好友
	public String deleteFriendByID(Integer friendID) {
		// 获取当前用户
		currentUser = sessionUtil.getSessionUser();
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// 获取指定好友
		friend = friendDAO.findFriendByID(friendID);
		if (friend == null)
			return INPUT;
		if (friend.getFriendUser().equals(currentUser))
			return NONE;
		// 查询相互好友
		if (friend.getFriendMutual().equals("是")) {
			friendMutual = friendDAO.findFriendByName(friend.getFriendUser(), currentUser);
			friendMutual.setFriendMutual(false);
		}
		// 更新数据库
		if (friendMutual!=null && !friendDAO.updateFriend(friendMutual))
			return ERROR;
		if (friendDAO.deleteFriendByID(friendID))
			return SUCCESS;
		return ERROR;
	}

	// 删除好友
	public String deleteFriendByName(String friendName) {
		// 获取当前用户
		currentUser = sessionUtil.getSessionUser();
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// 获取好友
		friend = friendDAO.findFriendByName(currentUser, friendName);
		if (friend == null)
			return INPUT;
		// 查询相互好友
		if (friend.getFriendMutual().equals("是")) {
			friendMutual = friendDAO.findFriendByName(friend.getFriendUser(), currentUser);
			friendMutual.setFriendMutual(false);
		}
		// 更新数据库
		if (friendMutual!=null && !friendDAO.updateFriend(friendMutual))
			return ERROR;
		if (friendDAO.deleteFriendByName(currentUser, friendName))
			return SUCCESS;
		return ERROR;
	}

	// 查询指定好友
	public Friend getFriendByID(Integer friendID) {
		return friendDAO.findFriendByID(friendID);
	}

	// 查询好友
	public Friend getFriendByName(String friendName) {
		// 获取当前用户
		currentUser = sessionUtil.getSessionUser();
		if (currentUser == null || currentUser.trim().length() == 0)
			return null;
		// 查询好友
		return friendDAO.findFriendByName(currentUser, friendName);
	}

	// 查询所有好友
	public List<Friend> getAllFriends() {
		// 获取当前用户
		currentUser = sessionUtil.getSessionUser();
		if (currentUser == null || currentUser.trim().length() == 0)
			return null;
		// 查询所有好友
		return friendDAO.findAllFriends(currentUser);
	}

}
