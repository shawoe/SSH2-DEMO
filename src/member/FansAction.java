package member;

import java.util.List;
import platform.BaseAction;

@SuppressWarnings("serial")
public class FansAction extends BaseAction {
	
	// 设置属性
	protected String fansName;
	protected FansService fansService;
	protected List<Fans> allFanss;

	// 添加好友
	public String addFans() throws Exception {
		// 参数检验
		if (fansName == null || fansName.trim().length() == 0) {
			this.addFieldError("fansName", "请选择好友");
			return INPUT;
		}
		// 添加好友
		String result = fansService.addFans(fansName);
		if (result.equals(INPUT)) {
			this.addFieldError("fansName", "好友已存在");
			return INPUT;
		}
		return returnAction(result);
	}

	// 查看所有好友
	public String showAllFanss() throws Exception {
		allFanss = fansService.findAll();
		if (allFanss != null) {
			this.addActionMessage("查看所有好友成功");
			return SUCCESS;
		}
		this.addActionMessage("当前没有好友");
		return NONE;
	}

	
	// 默认属性Getter/Setter
	public String getFansName() {
		return fansName;
	}

	public FansService getFansService() {
		return fansService;
	}

	public void setFansService(FansService fansService) {
		this.fansService = fansService;
	}

	public List<Fans> getAllFanss() {
		return allFanss;
	}

	public void setAllFanss(List<Fans> allFanss) {
		this.allFanss = allFanss;
	}

	public void setFansName(String fansName) {
		this.fansName = fansName;
	}
}
