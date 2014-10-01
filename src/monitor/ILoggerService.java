package monitor;

import java.util.List;

public interface ILoggerService {

	// 添加日志
	public abstract String send(String loggerAction);

	// 删除消息
	public abstract String remove(Integer loggerID);

	// 查询消息
	public abstract Logger find(Integer loggerID);
	public abstract List<Logger> findAll(Integer pageNow, Integer pageSize);
	public abstract List<Logger> findOperator(String loggerOperator);

	// 查询分页总数
	public abstract Integer count(Integer pageSize);

	// 编辑日志
	public abstract String edit(Integer loggerID, String loggerAction);

}