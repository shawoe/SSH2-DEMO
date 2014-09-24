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
		friend = friendDAO.findDataByUserName(currentUser,friendName);
		if (friend != null)
			return INPUT;
		// 增加好友
		friend = new Friend();
		friend.setFriendUser(currentUser);
		friend.setFriendTarget(friendName);
		friend.setFriendTime(simpleDateFormat.format(date));
		// 查询相互好友
		friendMutual = friendDAO.findDataByUserName(friendName,currentUser);
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
		currentUser = sessionUtil.getSessionUser();
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// 获取指定好友
		friend = friendDAO.find(friendID);
		if (friend == null)
			return INPUT;
		if (friend.getFriendUser().equals(currentUser))
			return NONE;
		// 查询相互好友
		if (friend.getFriendMutual().equals("是")) {
			friendMutual = friendDAO.findDataByUserName(friend.getFriendUser(), currentUser);
			friendMutual.setFriendMutual(false);
		}
		// 更新数据库
		if (friendMutual!=null && !friendDAO.update(friendMutual))
			return ERROR;
		if (friendDAO.delete(friendID))
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
		friend = friendDAO.findDataByUserName(currentUser, friendName);
		if (friend == null)
			return INPUT;
		// 查询相互好友
		if (friend.getFriendMutual().equals("是")) {
			friendMutual = friendDAO.findDataByUserName(friend.getFriendUser(), currentUser);
			friendMutual.setFriendMutual(false);
		}
		// 更新数据库
		if (friendMutual!=null && !friendDAO.update(friendMutual))
			return ERROR;
		if (friendDAO.deleteDataByUserName(currentUser, friendName))
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
		currentUser = sessionUtil.getSessionUser();
		if (currentUser == null || currentUser.trim().length() == 0)
			return null;
		// 查询好友
		return friendDAO.findDataByUserName(currentUser, friendName);
	}

	// 查询所有好友
	public List<Friend> getAllFriends() {
		// 获取当前用户
		currentUser = sessionUtil.getSessionUser();
		if (currentUser == null || currentUser.trim().length() == 0)
			return null;
		// 查询所有好友
		return friendDAO.findAll(currentUser);
	}

}
