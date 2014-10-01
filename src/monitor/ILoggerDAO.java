package monitor;

import java.util.List;
import platform.InterfaceDAO;

public interface ILoggerDAO extends InterfaceDAO<Logger> {

	// 查找日志
	public abstract List<Logger> selectAll();

	public abstract List<Logger> selectOperator(String loggerOperator);

	public abstract Logger select(Integer loggerID);

	// 删除日志
	public abstract boolean delete(Integer loggerID);

	public abstract boolean deleteOperator(String loggerOperator);

}