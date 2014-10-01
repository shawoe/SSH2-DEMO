package monitor;

import java.util.List;
import platform.BaseDAO;

public class LoggerDAO extends BaseDAO<Logger> implements ILoggerDAO {
	
	// 查找日志
	public List<Logger> selectAll() {
		List<Logger> loggerList = selectAll("Logger");
		return loggerList;
	}
	
	public List<Logger> selectOperator(String loggerOperator) {
		Logger loggerQuery = new Logger();
		loggerQuery.setLoggerOperator(loggerOperator);
		List<Logger> LoggerList = select(loggerQuery);
		return LoggerList;
	}
	
	public Logger select(Integer loggerID) {
		Logger loggerQuery = new Logger();
		loggerQuery.setLoggerID(loggerID);
		Logger Logger = select(loggerQuery).get(0);
		return Logger;
	}

	// 删除日志
	public boolean delete(Integer loggerID) {
		Logger loggerQuery = new Logger();
		loggerQuery.setLoggerID(loggerID);
		if (this.delete(loggerQuery))
			return true;
		return false;
	}

	public boolean deleteOperator(String loggerOperator) {
		Logger loggerQuery = new Logger();
		loggerQuery.setLoggerOperator(loggerOperator);
		if (this.delete(loggerQuery))
			return true;
		return false;
	}



}
