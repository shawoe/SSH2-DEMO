package message;

import java.util.List;
import platform.BaseAction;
import platform.InterfaceAction;

@SuppressWarnings("serial")
public class SMSAction extends BaseAction implements InterfaceAction {
	
	// 设置属性
	protected Integer userID;
	protected Integer SMSID;
	protected String SMSReader;
	protected String SMSContent;
	protected ISMSService SMSService;
	protected List<SMS> allSMS;

	protected Integer SMSPageNow; 	//初始化为1,默认从第一页开始显示
	protected Integer SMSPageSize; 	//每页显示5条记录
	protected Integer SMSPageCount;	//总页数
	
	protected static Integer pageNow = 1; 	//初始化为1,默认从第一页开始显示
	protected static Integer pageSize = 5; 	//每页显示5条记录
	protected static Integer pageCount = 0;	//总页数
	

	// 读第一页短消息
	public String readFirst() throws Exception {
		if (pageSize==null || pageSize <= 0)
			pageSize = 5;
		pageNow = 1;
		allSMS = SMSService.findCurrentUser(pageNow, pageSize);
		pageCount = SMSService.reterPageCount(pageSize);
		SMSPageNow = pageNow;
		SMSPageSize = pageSize;
		SMSPageCount = pageCount;
		return SUCCESS;	
	}
	
	// 读短消息
	public String read() throws Exception {
		if (SMSPageSize==null || SMSPageSize <= 0)
			SMSPageSize = 5;
		if (SMSPageNow==null || SMSPageNow <= 0)
			SMSPageNow = 1;
		pageNow = SMSPageNow;
		pageSize = SMSPageSize;
		allSMS = SMSService.findCurrentUser(pageNow, pageSize);
		pageCount = SMSService.reterPageCount(pageSize);
		SMSPageCount = pageCount;
		return SUCCESS;	
	}
	
	// 读下一页短消息
	public String readNext() throws Exception {
		if (pageSize==null || pageSize <= 0)
			pageSize = 5;
		if (pageNow==null || pageNow <= 0)
			pageNow = 1;
		if (pageCount==null || pageCount <= 0)
			pageCount = SMSService.reterPageCount(pageSize);
		if (pageNow < pageCount) 
			pageNow++;
		allSMS = SMSService.findCurrentUser(pageNow, pageSize);
		SMSPageNow = pageNow;
		SMSPageSize = pageSize;
		SMSPageCount = pageCount;
		return SUCCESS;	
	}
	
	// 读上一页短消息
	public String readLast() throws Exception {
		if (pageSize==null || pageSize <= 0)
			pageSize = 5;
		if (pageNow==null || pageNow <= 0)
			pageNow = 1;
		if (pageCount==null || pageCount <= 0)
			pageCount = SMSService.reterPageCount(pageSize);
		if (pageNow > 1) 
			pageNow--;
		allSMS = SMSService.findCurrentUser(pageNow, pageSize);
		SMSPageNow = pageNow;
		SMSPageSize = pageSize;
		SMSPageCount = pageCount;
		return SUCCESS;	
	}
	
	// 读最后一页短消息
	public String readEnd() throws Exception {
		if (pageSize==null || pageSize <= 0)
			pageSize = 5;
		if (pageNow==null || pageNow <= 0)
			pageNow = 1;
		if (pageCount==null || pageCount <= 0)
			pageCount = SMSService.reterPageCount(pageSize);
		if (pageCount > 1) 
			pageNow = pageCount;
		allSMS = SMSService.findCurrentUser(pageNow, pageSize);
		SMSPageNow = pageNow;
		SMSPageSize = pageSize;
		SMSPageCount = pageCount;
		return SUCCESS;	
	}
	
	// 发送短消息
	public String send() throws Exception {
		// 参数检验
		if (SMSReader==null || SMSReader.trim().length()==0) {
			this.addFieldError("SMSReader", "收信人不能为空");
			return INPUT;
		}
		if (SMSContent==null || SMSContent.trim().length()==0) { 
			this.addFieldError("SMSContent", "短信内容不能为空");
			return INPUT;
		}
		// 发送短消息
		String result = SMSService.send(SMSReader,SMSContent);
		return returnAction(result);
	}

	// 删除短消息
	public String delete() throws Exception {
		// 参数检验
		if (SMSID==null || SMSID <= 0) {
			this.addFieldError("SMSID", "请选择需要删除的短消息");
			return INPUT;
		}
		// 删除短消息
		String result = SMSService.remove(SMSID);
		if (result.equals(INPUT)) {
			this.addFieldError("SMSID", "请选择您要删除的短消息");
			return INPUT;
		}
		return returnAction(result);
	}

	// 修改短消息
	public String edit() throws Exception {
		// 参数检验
		if (SMSID==null || SMSID <= 0) {
			this.addFieldError("SMSID", "请选择需要修改的短消息");
			return INPUT;
		}
		if (SMSReader==null || SMSReader.trim().length()==0) {
			this.addFieldError("SMSReader", "收信人不能为空");
			return INPUT;
		}
		if (SMSContent==null || SMSContent.trim().length()==0) { 
			this.addFieldError("SMSContent", "短信内容不能为空");
			return INPUT;
		}
		// 修改短消息
		String result = SMSService.edit(SMSID,SMSReader,SMSContent);
		if (result.equals(INPUT)) {
			this.addFieldError("SMSID", "请选择您要修改的短消息");
			return INPUT;
		}
		return returnAction(result);
	}
	
	
	
	// 默认属性Getter/Setter
	public Integer getUserID() {
		return userID;
	}

	public Integer getSMSID() {
		return SMSID;
	}

	public void setSMSID(Integer SMSID) {
		this.SMSID = SMSID;
	}

	public String getSMSReader() {
		return SMSReader;
	}

	public void setSMSReader(String SMSReader) {
		this.SMSReader = SMSReader;
	}

	public String getSMSContent() {
		return SMSContent;
	}

	public void setSMSContent(String SMSContent) {
		this.SMSContent = SMSContent;
	}

	public ISMSService getSMSService() {
		return SMSService;
	}

	public void setSMSService(ISMSService SMSService) {
		this.SMSService = SMSService;
	}

	public List<SMS> getAllSMS() {
		return allSMS;
	}

	public void setAllSMS(List<SMS> allSMS) {
		this.allSMS = allSMS;
	}

	public Integer getSMSPageNow() {
		return SMSPageNow;
	}

	public void setSMSPageNow(Integer SMSPageNow) {
		this.SMSPageNow = SMSPageNow;
	}

	public Integer getSMSPageSize() {
		return SMSPageSize;
	}

	public void setSMSPageSize(Integer SMSPageSize) {
		this.SMSPageSize = SMSPageSize;
	}

	public Integer getSMSPageCount() {
		return SMSPageCount;
	}

	public void setSMSPageCount(Integer SMSPageCount) {
		this.SMSPageCount = SMSPageCount;
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
