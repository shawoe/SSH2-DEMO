package monitor;

import java.util.List;
import platform.BaseService;

public class LoggerService extends BaseService<Logger> implements ILoggerService {

	// ����ע������
	protected ILoggerDAO loggerDAO;
	
	// �����־
	public String send(String loggerAction) {
		// �����û���¼
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// ��д��־
		Logger logger = new Logger();
		logger.setLoggerOperator(currentUser);
		logger.setLoggerAction(loggerAction);
		logger.setLoggerTime(this.referCurrentDate());
		logger.setLoggerSuccess(true);
		logger.setLoggerError("-");
		// �������ݿ�
		if(loggerDAO.insert(logger))
			return SUCCESS;
		return ERROR;
	}

	// ɾ����Ϣ
	public String remove(Integer loggerID) {
		// �����û���¼
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		Logger logger = loggerDAO.select(loggerID);
		if (logger == null) 
			return INPUT;
		if (loggerDAO.delete(loggerID))
			return SUCCESS;
		return ERROR;
	}

	// ��ѯ��Ϣ
	public List<Logger> findAll(Integer pageNow, Integer pageSize) {
		List<Logger> loggerList = loggerDAO.selectAll();
		List<Logger> loggerPaging = this.paging(loggerList, pageNow, pageSize);
		return loggerPaging;
	}
	
	// ��ѯ��ҳ����
	public Integer count(Integer pageSize) {
		List<Logger> loggerList = loggerDAO.selectAll();
		Integer pageCount = this.count(loggerList,pageSize);
		return pageCount;
	}
	
	public List<Logger> findOperator(String loggerOperator) {
		List<Logger> loggerList = loggerDAO.selectOperator(loggerOperator);
		return loggerList;
	}
	
	public Logger find(Integer loggerID) {
		Logger logger = loggerDAO.select(loggerID);
		return logger;
	}

	// �༭��־
	public String edit(Integer loggerID, String loggerAction) {
		// ��֤�û���¼
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// ��ȡ��־
		Logger logger = loggerDAO.select(loggerID);
		if (logger == null) 
			return INPUT;
		// ��д��־
		logger.setLoggerOperator(currentUser);
		logger.setLoggerAction(loggerAction);
		logger.setLoggerTime(referCurrentDate());
		logger.setLoggerSuccess(true);
		logger.setLoggerError("-");
		// �������ݿ�
		if(loggerDAO.update(logger))
			return SUCCESS;
		return ERROR;
	}


	// ����Getter/Setter
	public ILoggerDAO getLoggerDAO() {
		return loggerDAO;
	}

	public void setLoggerDAO(ILoggerDAO loggerDAO) {
		this.loggerDAO = loggerDAO;
	}



	
}
