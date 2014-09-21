package message;


import java.util.List;


import util.PageUtil;



import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
public abstract class SMSActionBase extends ActionSupport{

	// 设置属性
	protected Integer userID;

	protected Integer smsID;
	protected String smsReader;
	protected String smsContent;
	protected ISMSService smsService;
	protected List<SMS> allSms;
	

	protected Integer smsPageNow; 	//初始化为1,默认从第一页开始显示
	protected Integer smsPageSize; 	//每页显示5条记录
	protected Integer smsPageCount;	//总页数
	
	protected PageUtil<SMS> page;			//页面处理工具
	protected static Integer pageNow = 1; 	//初始化为1,默认从第一页开始显示
	protected static Integer pageSize = 5; 	//每页显示5条记录
	protected static Integer pageCount = 0;	//总页数
	
	
	// 默认属性Getter/Setter
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
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
	public ISMSService getSmsService() {
		return smsService;
	}
	public void setSmsService(ISMSService smsService) {
		this.smsService = smsService;
	}
	public List<SMS> getAllSms() {
		return allSms;
	}
	public void setAllSms(List<SMS> allSms) {
		this.allSms = allSms;
	}
	public PageUtil<SMS> getPage() {
		return page;
	}
	public void setPage(PageUtil<SMS> page) {
		this.page = page;
	}
	public static Integer getPageNow() {
		return pageNow;
	}
	public static void setPageNow(Integer pageNow) {
		SMSActionBase.pageNow = pageNow;
	}
	public static Integer getPageSize() {
		return pageSize;
	}
	public static void setPageSize(Integer pageSize) {
		SMSActionBase.pageSize = pageSize;
	}
	public static Integer getPageCount() {
		return pageCount;
	}
	public static void setPageCount(Integer pageCount) {
		SMSActionBase.pageCount = pageCount;
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

	
}
