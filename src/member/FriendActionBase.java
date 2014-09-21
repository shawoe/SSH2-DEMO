package member;

import java.util.List;
import util.PageUtil;


import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
public abstract class FriendActionBase extends ActionSupport {
	
	// 设置属性
	protected String friendName;
	protected FriendService friendService;
	protected List<Friend> allFriends;
	
	// 声明静态属性
	protected PageUtil<Friend> page = new PageUtil<Friend>();


	// 默认属性Getter/Setter
	public String getFriendName() {
		return friendName;
	}
	
	public void setFriendName(String friendName) {
		this.friendName = friendName;
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

	public PageUtil<Friend> getPage() {
		return page;
	}

	public void setPage(PageUtil<Friend> page) {
		this.page = page;
	}
}
