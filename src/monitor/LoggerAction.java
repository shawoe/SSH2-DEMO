package monitor;

@SuppressWarnings("serial")
public class LoggerAction extends LoggerActionBase {
	// ����һҳ����Ϣ
	public String readFirst() throws Exception {
		if (pageSize==null || pageSize <= 0)
			pageSize = 5;
		pageNow = 1;
		allLogger = loggerService.getAll(pageNow, pageSize);
		pageCount = loggerService.getPageCount(pageSize);
		loggerPageNow = pageNow;
		loggerPageSize = pageSize;
		loggerPageCount = pageCount;
		return SUCCESS;	
	}
	
	// ������Ϣ
	public String read() throws Exception {
		if (loggerPageSize==null || loggerPageSize <= 0)
			loggerPageSize = 5;
		if (loggerPageNow==null || loggerPageNow <= 0)
			loggerPageNow = 1;
		pageNow = loggerPageNow;
		pageSize = loggerPageSize;
		allLogger = loggerService.getAll(pageNow, pageSize);
		pageCount = loggerService.getPageCount(pageSize);
		loggerPageCount = pageCount;
		return SUCCESS;	
	}
	
	// ����һҳ����Ϣ
	public String readNext() throws Exception {
		if (pageSize==null || pageSize <= 0)
			pageSize = 5;
		if (pageNow==null || pageNow <= 0)
			pageNow = 1;
		if (pageCount==null || pageCount <= 0)
			pageCount = loggerService.getPageCount(pageSize);
		if (pageNow < pageCount) 
			pageNow++;
		allLogger = loggerService.getAll(pageNow, pageSize);
		loggerPageNow = pageNow;
		loggerPageSize = pageSize;
		loggerPageCount = pageCount;
		return SUCCESS;	
	}
	
	// ����һҳ����Ϣ
	public String readLast() throws Exception {
		if (pageSize==null || pageSize <= 0)
			pageSize = 5;
		if (pageNow==null || pageNow <= 0)
			pageNow = 1;
		if (pageCount==null || pageCount <= 0)
			pageCount = loggerService.getPageCount(pageSize);
		if (pageNow > 1) 
			pageNow--;
		allLogger = loggerService.getAll(pageNow, pageSize);
		loggerPageNow = pageNow;
		loggerPageSize = pageSize;
		loggerPageCount = pageCount;
		return SUCCESS;	
	}
	
	// �����һҳ����Ϣ
	public String readEnd() throws Exception {
		if (pageSize==null || pageSize <= 0)
			pageSize = 5;
		if (pageNow==null || pageNow <= 0)
			pageNow = 1;
		if (pageCount==null || pageCount <= 0)
			pageCount = loggerService.getPageCount(pageSize);
		if (pageCount > 1) 
			pageNow = pageCount;
		allLogger = loggerService.getAll(pageNow, pageSize);
		loggerPageNow = pageNow;
		loggerPageSize = pageSize;
		loggerPageCount = pageCount;
		return SUCCESS;	
	}
		
}

