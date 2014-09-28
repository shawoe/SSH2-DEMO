package monitor;

import java.util.List;
import member.UserDAO;
import platform.BaseService;
import platform.InterfaceServiceMessage;

public class LoggerService extends BaseService<Logger> implements InterfaceServiceMessage<Logger>{

	// 依赖注入属性
	protected UserDAO userDAO;
	protected LoggerDAO loggerDAO;
	
	// 添加日志
	public String send(String loggerAction) {
		// 检验用户登录
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// 填写日志
		Logger logger = new Logger();
		logger.setLoggerOperator(currentUser);
		logger.setLoggerAction(loggerAction);
		logger.setLoggerTime(getCurrentDate());
		logger.setLoggerSuccess(true);
		logger.setLoggerError("-");
		// 存至数据库
		if(loggerDAO.insert(logger))
			return SUCCESS;
		return ERROR;
	}

	// 删除消息
	public String delete(Integer loggerID) {
		// 检验用户登录
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		Logger logger = loggerDAO.find(loggerID);
		if (logger == null) 
			return INPUT;
		if (loggerDAO.delete(loggerID))
			return SUCCESS;
		return ERROR;
	}

	// 查询消息
	public List<Logger> getAll(Integer pageNow, Integer pageSize) {
		List<Logger> loggerList = loggerDAO.findAll();
		List<Logger> loggerPaging = this.paging(loggerList, pageNow, pageSize);
		return loggerPaging;
	}
	
	// 查询分页总数
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

	// 编辑日志
	public String edit(Integer loggerID, String loggerAction) {
		// 获取当前用户
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// 获取日志
		Logger logger = loggerDAO.find(loggerID);
		if (logger == null) 
			return INPUT;
		// 填写日志
		logger.setLoggerOperator(currentUser);
		logger.setLoggerAction(loggerAction);
		logger.setLoggerTime(getCurrentDate());
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

	public String send(String reader, String content) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Logger> getUserMessage(Integer pageNow, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	// 属性Getter/Setter
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
