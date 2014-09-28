package member;

import java.util.List;
import platform.BaseAction;

@SuppressWarnings("serial")
public class FriendAction extends BaseAction {
	
	// 设置属性
	protected String friendName;
	protected FriendService friendService;
	protected List<Friend> allFriends;

	// 添加好友
	public String addFriend() throws Exception {
		// 参数检验
		if (friendName == null || friendName.trim().length() == 0) {
			this.addFieldError("friendName", "请选择好友");
			return INPUT;
		}
		// 添加好友
		String result = friendService.addFriend(friendName);
		if (result.equals(INPUT)) {
			this.addFieldError("friendName", "好友已存在");
			return INPUT;
		}
		return returnAction(result);
	}

	// 查看所有好友
	public String showAllFriends() throws Exception {
		allFriends = friendService.getAllFriends();
		if (allFriends != null) {
			this.addActionMessage("查看所有好友成功");
			return SUCCESS;
		}
		this.addActionMessage("当前没有好友");
		return NONE;
	}

	
	// 默认属性Getter/Setter
	public String getFriendName() {
		return friendName;
	}

	public FriendService getFriendService() {
		return friendService;
	}

	public void setFriendService(FriendService friendService) {
		this.friendService = friendService;
	}

	public List<Friend> getAllFriends() {
		return allFriends;
	}

	public void setAllFriends(List<Friend> allFriends) {
		this.allFriends = allFriends;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}
}
