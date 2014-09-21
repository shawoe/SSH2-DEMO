package member;

@SuppressWarnings("serial")
public class FriendAction extends FriendActionBase {

	// 添加好友
	public String addFriend() throws Exception {
		// 参数检验
		if (friendName == null || friendName.trim().length() == 0) {
			this.addFieldError("friendName", "请选择好友");
			return INPUT;
		}
		// 添加好友
		String result = friendService.addFriend(friendName);
		if (result.equals(LOGIN)) {
			this.addActionError("您尚未登录，请重新登录");
			return LOGIN;
		}
		if (result.equals(INPUT)) {
			this.addFieldError("friendName", "好友已存在");
			return INPUT;
		}
		if (result.equals(SUCCESS)) {
			this.addActionMessage("成功添加好友");
			return SUCCESS;
		}
		this.addActionError("添加好友失败");
		return ERROR;
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

}
