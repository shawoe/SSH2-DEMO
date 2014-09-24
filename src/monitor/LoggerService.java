package monitor;

import java.util.List;
import api.InterfaceServiceMessage;

public class LoggerService extends LoggerServiceBase implements InterfaceServiceMessage<Logger>{

	// �����־
	public String send(String loggerAction) {
		// ��ȡ��ǰ�û�
		currentUser = sessionUtil.getSessionUser();
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// ��д��־
		logger.setLoggerUser(currentUser);
		logger.setLoggerAction(loggerAction);
		logger.setLoggerTime(simpleDateFormat.format(date));
		logger.setLoggerSuccess(true);
		logger.setLoggerError("-");
		// �������ݿ�
		if(loggerDAO.insert(logger))
			return SUCCESS;
		return ERROR;
	}


	// ɾ����Ϣ
	public String delete(Integer loggerID) {
		// ��ȡ��ǰ�û�
		currentUser = sessionUtil.getSessionUser();
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		logger = loggerDAO.find(loggerID);
		if (logger == null) 
			return INPUT;
		if (loggerDAO.delete(loggerID))
			return SUCCESS;
		return ERROR;
	}

	// ��ѯ��Ϣ
	public List<Logger> getAll() {
		List<Logger> loggerList = loggerDAO.findAll();
		return loggerList;
	}
	
	public List<Logger> getMessageByUserName(String loggerUser) {
		List<Logger> loggerList = loggerDAO.findDataByUserName(loggerUser);
		return loggerList;
	}
	
	public Logger get(Integer loggerID) {
		Logger logger = loggerDAO.find(loggerID);
		return logger;
	}

	// �༭��־
	public String edit(Integer loggerID, String loggerAction) {
		// ��ȡ��ǰ�û�
		currentUser = sessionUtil.getSessionUser();
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// ��ȡ��־
		logger = loggerDAO.find(loggerID);
		if (logger == null) 
			return INPUT;
		// ��д��־
		logger.setLoggerUser(currentUser);
		logger.setLoggerAction(loggerAction);
		logger.setLoggerTime(simpleDateFormat.format(date));
		logger.setLoggerSuccess(true);
		logger.setLoggerError("-");
		// �������ݿ�
		if(loggerDAO.update(logger))
			return SUCCESS;
		return ERROR;
	}


	public String edit(Integer id, String reader, String content) {
		// TODO Auto-generated method stub
		return null;
	}


	public Integer getPageCount(Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}


	public String send(String reader, String content) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Logger> getMessageByUserName(Integer pageNow, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}



	
}
