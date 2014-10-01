package message;

import java.util.List;
import platform.BaseDAO;

public class SMSDAO extends BaseDAO<SMS> implements ISMSDAO  {
	
	// 查找信息
	public List<SMS> selectReader(String SMSReader) {
		SMS SMSQuery = new SMS();
		SMSQuery.setSMSReader(SMSReader);
		List<SMS> SMSList = select(SMSQuery);
		return SMSList;
	}     

	public SMS select(Integer SMSID) {
		SMS SMSQuery = new SMS();
		SMSQuery.setSMSID(SMSID);
		SMS SMS = select(SMSQuery).get(0);		
		return SMS;
	}

	public List<SMS> selectAll() {
		List<SMS> SMSList = selectAll("SMS");
		return SMSList;
	}

	public List<SMS> selectSender(String SMSSender) {
		SMS SMSQuery = new SMS();
		SMSQuery.setSMSSender(SMSSender);
		List<SMS> SMSList = select(SMSQuery);
		return SMSList;
	}

	// 删除信息
	public boolean delete(Integer SMSID) {
		SMS SMSQuery = new SMS();
		SMSQuery.setSMSID(SMSID);
		if (delete(SMSQuery))
			return true;
		return false;
	}

	public boolean deleteReader(String SMSReader) {
		SMS SMSQuery = new SMS();
		SMSQuery.setSMSReader(SMSReader);
		if (delete(SMSQuery))
			return true;
		return false;
	}

	public boolean deleteSender(String SMSSender) {
		SMS SMSQuery = new SMS();
		SMSQuery.setSMSSender(SMSSender);
		if (delete(SMSQuery))
			return true;
		return false;
	}

}
