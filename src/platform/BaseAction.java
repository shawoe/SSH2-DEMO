package platform;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BaseAction extends ActionSupport {
	
	// 参数检验
	public boolean check(String[] argsName, String[] argsField, String... args) { 		
		int i = 0;
		boolean input = false;
        for (String arg : args) {  
        	if (arg == null || arg.trim().length() == 0) {
        		this.addFieldError(argsField[i], argsName[i] + "不能为空");
        		input = true;
        	}
        	i++;
        }  
        return input;
    }  

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
