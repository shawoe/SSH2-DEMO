package message;

import java.util.List;
import platform.BaseService;

public class SMSService extends BaseService<SMS> implements ISMSService {
	
	// 依赖注入属性
	protected ISMSDAO SMSDAO;

	// 发送短消息
	public String send(String SMSReader, String SMSContent) {
		// 验证用户登录
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// 填写信息
		SMS SMS = new SMS();
		SMS.setSMSSender(currentUser);
		SMS.setSMSReader(SMSReader);
		SMS.setSMSContent(SMSContent);
		SMS.setSMSRead(false);
		SMS.setSMSTime(referCurrentDate());
		// 存至数据库
		if(SMSDAO.insert(SMS))
			return SUCCESS;
		return ERROR;
	}

	// 删除指定短消息
	public String remove(Integer SMSID) {
		// 验证用户登录
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		SMS SMS = SMSDAO.select(SMSID);
		if (SMS == null) 
			return INPUT;
		if (!SMS.getSMSSender().equals(currentUser))
			return NONE;
		if (SMSDAO.delete(SMSID))
			return SUCCESS;
		return ERROR;
	}

	// 查询用户短消息
	public List<SMS> findCurrentUser(Integer pageNow, Integer pageSize) {
		if (currentUser!=null && currentUser.trim().length() > 0) {
			List<SMS> SMSList = SMSDAO.selectReader(currentUser);
			List<SMS> SMSPaging = this.paging(SMSList, pageNow, pageSize);
			return SMSPaging;
		}
		return null;
	}
	
	// 查询分页总数
	public Integer reterPageCount(Integer pageSize) {
		List<SMS> SMSList = SMSDAO.selectReader(currentUser);
		Integer pageCount = this.count(SMSList,pageSize);
		return pageCount;
	}

	// 查询指定短消息
	public SMS find(Integer SMSID) {
		SMS SMS = SMSDAO.select(SMSID);
		return SMS;
	}

	// 编辑短消息
	public String edit(Integer SMSID, String SMSReader, String SMSContent) {
		// 验证用户登录
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// 获取短消息
		SMS SMS = SMSDAO.select(SMSID);
		if (SMS == null) 
			return INPUT;
		if (!SMS.getSMSSender().equals(currentUser)) 
			return NONE;
		// 编辑短消息
		SMS.setSMSReader(SMSReader);
		SMS.setSMSContent(SMSContent);
		SMS.setSMSRead(false);
		SMS.setSMSTime(referCurrentDate());
		// 存至数据库
		if(SMSDAO.update(SMS))
			return SUCCESS;
		return ERROR;
	}


	// 默认属性Getter/Setter
	public ISMSDAO getSMSDAO() {
		return SMSDAO;
	}

	public void setSMSDAO(ISMSDAO sMSDAO) {
		SMSDAO = sMSDAO;
	}
	
}
