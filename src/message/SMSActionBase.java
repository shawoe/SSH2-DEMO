package message;


import java.util.List;


import util.PageUtil;



import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
public abstract class SMSActionBase extends ActionSupport{

	// ��������
	protected Integer userID;

	protected Integer smsID;
	protected String smsReader;
	protected String smsContent;
	protected ISMSService smsService;
	protected List<SMS> allSms;
	

	protected Integer smsPageNow; 	//��ʼ��Ϊ1,Ĭ�ϴӵ�һҳ��ʼ��ʾ
	protected Integer smsPageSize; 	//ÿҳ��ʾ5����¼
	protected Integer smsPageCount;	//��ҳ��
	
	protected PageUtil<SMS> page;			//ҳ�洦����
	protected static Integer pageNow = 1; 	//��ʼ��Ϊ1,Ĭ�ϴӵ�һҳ��ʼ��ʾ
	protected static Integer pageSize = 5; 	//ÿҳ��ʾ5����¼
	protected static Integer pageCount = 0;	//��ҳ��
	
	
	// Ĭ������Getter/Setter
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
