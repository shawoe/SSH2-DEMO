package monitor;

import java.util.List;
import platform.BaseService;

public class LoggerService extends BaseService<Logger> implements ILoggerService {

	// 依赖注入属性
	protected ILoggerDAO loggerDAO;
	
	// 添加日志
	public String send(String loggerAction) {
		// 检验用户登录
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// 填写日志
		Logger logger = new Logger();
		logger.setLoggerOperator(currentUser);
		logger.setLoggerAction(loggerAction);
		logger.setLoggerTime(this.referCurrentDate());
		logger.setLoggerSuccess(true);
		logger.setLoggerError("-");
		// 存至数据库
		if(loggerDAO.insert(logger))
			return SUCCESS;
		return ERROR;
	}

	// 删除消息
	public String remove(Integer loggerID) {
		// 检验用户登录
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		Logger logger = loggerDAO.select(loggerID);
		if (logger == null) 
			return INPUT;
		if (loggerDAO.delete(loggerID))
			return SUCCESS;
		return ERROR;
	}

	// 查询消息
	public List<Logger> findAll(Integer pageNow, Integer pageSize) {
		List<Logger> loggerList = loggerDAO.selectAll();
		List<Logger> loggerPaging = this.paging(loggerList, pageNow, pageSize);
		return loggerPaging;
	}
	
	// 查询分页总数
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

	// 编辑日志
	public String edit(Integer loggerID, String loggerAction) {
		// 验证用户登录
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// 获取日志
		Logger logger = loggerDAO.select(loggerID);
		if (logger == null) 
			return INPUT;
		// 填写日志
		logger.setLoggerOperator(currentUser);
		logger.setLoggerAction(loggerAction);
		logger.setLoggerTime(referCurrentDate());
		logger.setLoggerSuccess(true);
		logger.setLoggerError("-");
		// 存至数据库
		if(loggerDAO.update(logger))
			return SUCCESS;
		return ERROR;
	}


	// 属性Getter/Setter
	public ILoggerDAO getLoggerDAO() {
		return loggerDAO;
	}

	public void setLoggerDAO(ILoggerDAO loggerDAO) {
		this.loggerDAO = loggerDAO;
	}



	
}
