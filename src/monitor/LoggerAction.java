package monitor;

import java.util.List;

import org.apache.struts2.ServletActionContext;

@SuppressWarnings("serial")
public class LoggerAction extends LoggerActionBase {
		
	// 查看所有系统日志
	public String all() throws Exception {
		//通过调用业务逻辑组件获得所有的日志
		List<Logger> alllogger = loggerService.getAll();
		//将所有用户List储存在request范围中
		ServletActionContext.getRequest().setAttribute("alllogger", alllogger);
		return SUCCESS;
	}
}

