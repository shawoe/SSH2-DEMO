package member;

import java.text.SimpleDateFormat;
import java.util.Date;
import util.SessionUtil;

public abstract class FriendServiceBase {

	// 设置属性
	protected String currentUser;
	protected Friend friend;
	protected Friend friendMutual;
	
	
	// 依赖注入属性
	protected FriendDAO friendDAO;
	protected Date date;
	protected SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	protected SessionUtil sessionUtil;

	// 返回值常量
	public static final String SUCCESS = "success";
	public static final String NONE = "none";
	public static final String ERROR = "error";
	public static final String INPUT = "input";
	public static final String LOGIN = "login"; 
	

	// 默认属性Getter/Setter
	public Friend getFriend() {
		return friend;
	}
	public void setFriend(Friend friend) {
		this.friend = friend;
	}
	public FriendDAO getFriendDAO() {
		return friendDAO;
	}
	public void setFriendDAO(FriendDAO friendDAO) {
		this.friendDAO = friendDAO;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public SimpleDateFormat getSimpleDateFormat() {
		return simpleDateFormat;
	}
	public void setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
		this.simpleDateFormat = simpleDateFormat;
	}
	public SessionUtil getSessionUtil() {
		return sessionUtil;
	}
	public void setSessionUtil(SessionUtil sessionUtil) {
		this.sessionUtil = sessionUtil;
	}
	public String getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}
	public Friend getFriendMutual() {
		return friendMutual;
	}
	public void setFriendMutual(Friend friendMutual) {
		this.friendMutual = friendMutual;
	}

}
