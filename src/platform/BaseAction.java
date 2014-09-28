package platform;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BaseAction extends ActionSupport {
	
	// 返回信息
	public String returnAction(String result){
		if (result.equals(LOGIN)) {
			this.addActionError("您尚未登录，请登录");
		}
		if (result.equals(NONE)) {
			this.addActionError("用户不存在或您无权执行此操作");
		}
		if (result.equals(SUCCESS)) {
			this.addActionMessage("操作成功");
		}
		if (result.equals(ERROR)) {
			this.addActionError("操作失败");
		}
		return result;
	}
	
	
}
