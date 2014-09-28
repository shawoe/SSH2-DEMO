package message;

import java.util.List;
import platform.BaseAction;
import platform.InterfaceActionMessage;

@SuppressWarnings("serial")
public class SMSAction extends BaseAction implements InterfaceActionMessage {
	
	// 设置属性
	protected Integer userID;
	protected Integer smsID;
	protected String smsReader;
	protected String smsContent;
	protected SMSService smsService;
	protected List<SMS> allSMS;

	protected Integer smsPageNow; 	//初始化为1,默认从第一页开始显示
	protected Integer smsPageSize; 	//每页显示5条记录
	protected Integer smsPageCount;	//总页数
	
	protected static Integer pageNow = 1; 	//初始化为1,默认从第一页开始显示
	protected static Integer pageSize = 5; 	//每页显示5条记录
	protected static Integer pageCount = 0;	//总页数
	

	// 读第一页短消息
	public String readFirst() throws Exception {
		if (pageSize==null || pageSize <= 0)
			pageSize = 5;
		pageNow = 1;
		allSMS = smsService.getUserMessage(pageNow, pageSize);
		pageCount = smsService.getPageCount(pageSize);
		smsPageNow = pageNow;
		smsPageSize = pageSize;
		smsPageCount = pageCount;
		return SUCCESS;	
	}
	
	// 读短消息
	public String read() throws Exception {
		if (smsPageSize==null || smsPageSize <= 0)
			smsPageSize = 5;
		if (smsPageNow==null || smsPageNow <= 0)
			smsPageNow = 1;
		pageNow = smsPageNow;
		pageSize = smsPageSize;
		allSMS = smsService.getUserMessage(pageNow, pageSize);
		pageCount = smsService.getPageCount(pageSize);
		smsPageCount = pageCount;
		return SUCCESS;	
	}
	
	// 读下一页短消息
	public String readNext() throws Exception {
		if (pageSize==null || pageSize <= 0)
			pageSize = 5;
		if (pageNow==null || pageNow <= 0)
			pageNow = 1;
		if (pageCount==null || pageCount <= 0)
			pageCount = smsService.getPageCount(pageSize);
		if (pageNow < pageCount) 
			pageNow++;
		allSMS = smsService.getUserMessage(pageNow, pageSize);
		smsPageNow = pageNow;
		smsPageSize = pageSize;
		smsPageCount = pageCount;
		return SUCCESS;	
	}
	
	// 读上一页短消息
	public String readLast() throws Exception {
		if (pageSize==null || pageSize <= 0)
			pageSize = 5;
		if (pageNow==null || pageNow <= 0)
			pageNow = 1;
		if (pageCount==null || pageCount <= 0)
			pageCount = smsService.getPageCount(pageSize);
		if (pageNow > 1) 
			pageNow--;
		allSMS = smsService.getUserMessage(pageNow, pageSize);
		smsPageNow = pageNow;
		smsPageSize = pageSize;
		smsPageCount = pageCount;
		return SUCCESS;	
	}
	
	// 读最后一页短消息
	public String readEnd() throws Exception {
		if (pageSize==null || pageSize <= 0)
			pageSize = 5;
		if (pageNow==null || pageNow <= 0)
			pageNow = 1;
		if (pageCount==null || pageCount <= 0)
			pageCount = smsService.getPageCount(pageSize);
		if (pageCount > 1) 
			pageNow = pageCount;
		allSMS = smsService.getUserMessage(pageNow, pageSize);
		smsPageNow = pageNow;
		smsPageSize = pageSize;
		smsPageCount = pageCount;
		return SUCCESS;	
	}
	
	// 发送短消息
	public String send() throws Exception {
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
		String result = smsService.send(smsReader,smsContent);
		return returnAction(result);
	}

	// 删除短消息
	public String delete() throws Exception {
		// 参数检验
		if (smsID==null || smsID <= 0) {
			this.addFieldError("smsID", "请选择需要删除的短消息");
			return INPUT;
		}
		// 删除短消息
		String result = smsService.delete(smsID);
		if (result.equals(INPUT)) {
			this.addFieldError("smsID", "请选择您要删除的短消息");
			return INPUT;
		}
		return returnAction(result);
	}

	// 修改短消息
	public String edit() throws Exception {
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
		String result = smsService.edit(smsID,smsReader,smsContent);
		if (result.equals(INPUT)) {
			this.addFieldError("smsID", "请选择您要修改的短消息");
			return INPUT;
		}
		return returnAction(result);
	}
	
	
	
	// 默认属性Getter/Setter
	public Integer getUserID() {
		return userID;
	}

	public Integer getSmsID() {
		return smsID;
	}

	public void setSmsID(Integer smsID) {
		this.smsID = smsID;
	}

	public String getSmsReader() {
		return smsReader;
	}

	public void setSmsReader(String smsReader) {
		this.smsReader = smsReader;
	}

	public String getSmsContent() {
		return smsContent;
	}

	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}

	public SMSService getSmsService() {
		return smsService;
	}

	public void setSmsService(SMSService smsService) {
		this.smsService = smsService;
	}

	public List<SMS> getAllSMS() {
		return allSMS;
	}

	public void setAllSMS(List<SMS> allSMS) {
		this.allSMS = allSMS;
	}

	public Integer getSmsPageNow() {
		return smsPageNow;
	}

	public void setSmsPageNow(Integer smsPageNow) {
		this.smsPageNow = smsPageNow;
	}

	public Integer getSmsPageSize() {
		return smsPageSize;
	}

	public void setSmsPageSize(Integer smsPageSize) {
		this.smsPageSize = smsPageSize;
	}

	public Integer getSmsPageCount() {
		return smsPageCount;
	}

	public void setSmsPageCount(Integer smsPageCount) {
		this.smsPageCount = smsPageCount;
	}

	public static Integer getPageNow() {
		return pageNow;
	}

	public static void setPageNow(Integer pageNow) {
		SMSAction.pageNow = pageNow;
	}

	public static Integer getPageSize() {
		return pageSize;
	}

	public static void setPageSize(Integer pageSize) {
		SMSAction.pageSize = pageSize;
	}

	public static Integer getPageCount() {
		return pageCount;
	}

	public static void setPageCount(Integer pageCount) {
		SMSAction.pageCount = pageCount;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	
}
