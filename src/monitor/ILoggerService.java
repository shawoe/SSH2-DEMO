package monitor;

import java.util.List;

public interface ILoggerService {

	// �����־
	public abstract String send(String loggerAction);

	// ɾ����Ϣ
	public abstract String remove(Integer loggerID);

	// ��ѯ��Ϣ
	public abstract Logger find(Integer loggerID);
	public abstract List<Logger> findAll(Integer pageNow, Integer pageSize);
	public abstract List<Logger> findOperator(String loggerOperator);

	// ��ѯ��ҳ����
	public abstract Integer count(Integer pageSize);

	// �༭��־
	public abstract String edit(Integer loggerID, String loggerAction);

}