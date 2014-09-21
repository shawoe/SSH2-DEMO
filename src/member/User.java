package member;

public class User extends UserBase{
	
	// 默认构造方法
	public User() {
	}
	
	// 调用父类构造方法
	public User(Integer userID) {
		super(userID);
	}
}
