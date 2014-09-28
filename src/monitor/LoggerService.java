package monitor;

import java.util.List;
import member.UserDAO;
import platform.BaseService;
import platform.InterfaceServiceMessage;

public class LoggerService extends BaseService<Logger> implements InterfaceServiceMessage<Logger>{

	// ����ע������
	protected UserDAO userDAO;
	protected LoggerDAO loggerDAO;
	
	// �����־
	public String send(String loggerAction) {
		// �����û���¼
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// ��д��־
		Logger logger = new Logger();
		logger.setLoggerOperator(currentUser);
		logger.setLoggerAction(loggerAction);
		logger.setLoggerTime(getCurrentDate());
		logger.setLoggerSuccess(true);
		logger.setLoggerError("-");
		// �������ݿ�
		if(loggerDAO.insert(logger))
			return SUCCESS;
		return ERROR;
	}

	// ɾ����Ϣ
	public String delete(Integer loggerID) {
		// �����û���¼
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		Logger logger = loggerDAO.find(loggerID);
		if (logger == null) 
			return INPUT;
		if (loggerDAO.delete(loggerID))
			return SUCCESS;
		return ERROR;
	}

	// ��ѯ��Ϣ
	public List<Logger> getAll(Integer pageNow, Integer pageSize) {
		List<Logger> loggerList = loggerDAO.findAll();
		List<Logger> loggerPaging = this.paging(loggerList, pageNow, pageSize);
		return loggerPaging;
	}
	
	// ��ѯ��ҳ����
	public Integer getPageCount(Integer pageSize) {
		List<Logger> loggerList = loggerDAO.findAll();
		Integer pageCount = this.count(loggerList,pageSize);
		return pageCount;
	}
	
	public List<Logger> getUserMessage(String loggerUser) {
		List<Logger> loggerList = loggerDAO.findUserData(loggerUser);
		return loggerList;
	}
	
	public Logger get(Integer loggerID) {
		Logger logger = loggerDAO.find(loggerID);
		return logger;
	}

	// �༭��־
	public String edit(Integer loggerID, String loggerAction) {
		// ��ȡ��ǰ�û�
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// ��ȡ��־
		Logger logger = loggerDAO.find(loggerID);
		if (logger == null) 
			return INPUT;
		// ��д��־
		logger.setLoggerOperator(currentUser);
		logger.setLoggerAction(loggerAction);
		logger.setLoggerTime(getCurrentDate());
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

	public String send(String reader, String content) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Logger> getUserMessage(Integer pageNow, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	// ����Getter/Setter
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public LoggerDAO getLoggerDAO() {
		return loggerDAO;
	}

	public void setLoggerDAO(LoggerDAO loggerDAO) {
		this.loggerDAO = loggerDAO;
	}



	
}
