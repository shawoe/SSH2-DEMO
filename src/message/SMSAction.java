package message;




@SuppressWarnings("serial")
public class SMSAction extends SMSActionBase implements ISMSAction {

	// 读第一页短消息
	public String readFirstSms() throws Exception {
		if (pageSize==null || pageSize <= 0)
			pageSize = 5;
		pageNow = 1;
		allSms = smsService.getSmsByCurrentUser(pageNow, pageSize);
		pageCount = smsService.getSmsPageCount(pageSize);
		smsPageNow = pageNow;
		smsPageSize = pageSize;
		smsPageCount = pageCount;
		return SUCCESS;	
	}
	
	// 读短消息
	public String readSms() throws Exception {
		if (smsPageSize==null || smsPageSize <= 0)
			smsPageSize = 5;
		if (smsPageNow==null || smsPageNow <= 0)
			smsPageNow = 1;
		pageNow = smsPageNow;
		pageSize = smsPageSize;
		allSms = smsService.getSmsByCurrentUser(pageNow, pageSize);
		pageCount = smsService.getSmsPageCount(pageSize);
		smsPageCount = pageCount;
		return SUCCESS;	
	}
	
	// 读下一页短消息
	public String readNextSms() throws Exception {
		if (pageSize==null || pageSize <= 0)
			pageSize = 5;
		if (pageNow==null || pageNow <= 0)
			pageNow = 1;
		if (pageCount==null || pageCount <= 0)
			pageCount = smsService.getSmsPageCount(pageSize);
		if (pageNow < pageCount) 
			pageNow++;
		allSms = smsService.getSmsByCurrentUser(pageNow, pageSize);
		smsPageNow = pageNow;
		smsPageSize = pageSize;
		smsPageCount = pageCount;
		return SUCCESS;	
	}
	
	// 读上一页短消息
	public String readLastSms() throws Exception {
		if (pageSize==null || pageSize <= 0)
			pageSize = 5;
		if (pageNow==null || pageNow <= 0)
			pageNow = 1;
		if (pageCount==null || pageCount <= 0)
			pageCount = smsService.getSmsPageCount(pageSize);
		if (pageNow > 1) 
			pageNow--;
		allSms = smsService.getSmsByCurrentUser(pageNow, pageSize);
		smsPageNow = pageNow;
		smsPageSize = pageSize;
		smsPageCount = pageCount;
		return SUCCESS;	
	}
	
	// 读最后一页短消息
	public String readEndSms() throws Exception {
		if (pageSize==null || pageSize <= 0)
			pageSize = 5;
		if (pageNow==null || pageNow <= 0)
			pageNow = 1;
		if (pageCount==null || pageCount <= 0)
			pageCount = smsService.getSmsPageCount(pageSize);
		if (pageCount > 1) 
			pageNow = pageCount;
		allSms = smsService.getSmsByCurrentUser(pageNow, pageSize);
		smsPageNow = pageNow;
		smsPageSize = pageSize;
		smsPageCount = pageCount;
		return SUCCESS;	
	}
	
	// 发送短消息
	public String sendSms() throws Exception {
		// 参数检验
		if (smsReader==null || smsReader.trim().length()==0) {
			this.addFieldError("smsReader", "收信人不能为空");
			return INPUT;
		}
		if (smsContent==null || smsContent.trim().length()==0) { 
			this.addFieldError("smsContent", "短信内容不能为空");
			return INPUT;
		}
		// 发送短消息
		String result = smsService.sendSms(smsReader,smsContent);
		if (result.equals(LOGIN)) {
			this.addActionError("您尚未登录，请重新登录");
			return LOGIN;
		}
		if (result.equals(NONE)) {
			this.addActionError("用户不存在");
			return NONE;
		}
		if (result.equals(SUCCESS)) {
			this.addActionMessage("发送短消息成功");
			return SUCCESS;
		}
		this.addActionError("发送短消息失败");
		return ERROR;
	}

	// 删除短消息
	public String deleteSms() throws Exception {
		// 参数检验
		if (smsID==null || smsID <= 0) {
			this.addFieldError("smsID", "请选择需要删除的短消息");
			return INPUT;
		}
		// 删除短消息
		String result = smsService.deleteSmsByID(smsID);
		if (result.equals(LOGIN)) {
			this.addActionError("您尚未登录，请重新登录");
			return LOGIN;
		}
		if (result.equals(INPUT)) {
			this.addFieldError("smsID", "请选择您要删除的短消息");
			return INPUT;
		}
		if (result.equals(NONE)) {
			this.addActionError("您无权删除此消息");
			return NONE;
		}
		if (result.equals(SUCCESS)) {
			this.addActionMessage("删除短消息成功");
			return SUCCESS;
		}
		this.addActionError("删除短消息失败");
		return ERROR;
	}

	// 修改短消息
	public String editSms() throws Exception {
		// 参数检验
		if (smsID==null || smsID <= 0) {
			this.addFieldError("smsID", "请选择需要修改的短消息");
			return INPUT;
		}
		if (smsReader==null || smsReader.trim().length()==0) {
			this.addFieldError("smsReader", "收信人不能为空");
			return INPUT;
		}
		if (smsContent==null || smsContent.trim().length()==0) { 
			this.addFieldError("smsContent", "短信内容不能为空");
			return INPUT;
		}
		// 修改短消息
		String result = smsService.editSms(smsID,smsReader,smsContent);
		if (result.equals(LOGIN)) {
			this.addActionError("您尚未登录，请重新登录");
			return LOGIN;
		}
		if (result.equals(INPUT)) {
			this.addFieldError("smsID", "请选择您要修改的短消息");
			return INPUT;
		}
		if (result.equals(NONE)) {
			this.addActionError("您无权修改此消息");
			return NONE;
		}
		if (result.equals(SUCCESS)) {
			this.addActionMessage("修改短消息成功");
			return SUCCESS;
		}
		this.addActionError("修改短消息失败");
		return ERROR;
	}
	
}
