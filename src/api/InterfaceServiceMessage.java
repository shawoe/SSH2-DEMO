package api;

import java.util.List;

public interface InterfaceServiceMessage<Template> {

	// 发送信息
	public abstract String send(String reader, String content);

	// 删除信息
	public abstract String delete(Integer id);

	// 查询信息
	public abstract Template get(Integer id);
	public abstract List<Template> getAll(Integer pageNow, Integer pageSize);
	public abstract List<Template> getMessageByUserName(Integer pageNow, Integer pageSize);

	// 获取分页
	public abstract Integer getPageCount(Integer pageSize);

	// 编辑信息
	public abstract String edit(Integer id, String reader, String content);

}