package monitor;

import java.util.List;
import api.InterfaceServiceMessage;

public class LoggerService extends LoggerServiceBase implements InterfaceServiceMessage<Logger>{

	// 添加日志
	public String send(String loggerAction) {
		// 获取当前用户
		currentUser = sessionUtil.getSessionUser();
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// 填写日志
		logger.setLoggerUser(currentUser);
		logger.setLoggerAction(loggerAction);
		logger.setLoggerTime(simpleDateFormat.format(date));
		logger.setLoggerSuccess(true);
		logger.setLoggerError("-");
		// 存至数据库
		if(loggerDAO.insert(logger))
			return SUCCESS;
		return ERROR;
	}


	// 删除消息
	public String delete(Integer loggerID) {
		// 获取当前用户
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

	// 查询消息
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

	// 编辑日志
	public String edit(Integer loggerID, String loggerAction) {
		// 获取当前用户
		currentUser = sessionUtil.getSessionUser();
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// 获取日志
		logger = loggerDAO.find(loggerID);
		if (logger == null) 
			return INPUT;
		// 填写日志
		logger.setLoggerUser(currentUser);
		logger.setLoggerAction(loggerAction);
		logger.setLoggerTime(simpleDateFormat.format(date));
		logger.setLoggerSuccess(true);
		logger.setLoggerError("-");
		// 存至数据库
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
