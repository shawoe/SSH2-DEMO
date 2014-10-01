package platform;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import member.IUserDAO;

public abstract class BaseService<Template> implements InterfaceService<Template> {
	
	// 设置属性
	protected IUserDAO userDAO;
	protected String currentUser;
	
	// 默认构造方法
	protected BaseService(){
		currentUser = SessionContext.getSessionValue("currentUser");
	}
	
	// 设置当前用户
	public boolean recordCurrentUser(String userName) {
		return SessionContext.setSessionValue("currentUser", userName);
	}
	
	// 移除当前用户
	public boolean removeCurrentUser() {
		return SessionContext.removeSessionValue("currentUser");
	}
	
	// 获得系统时间
	public String referCurrentDate() {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return simpleDateFormat.format(date);		
	}
	
	// 上传图片
	public boolean uploadImage(File imageFile, String imageFileName, String imageContentType, String imageFolder, String renameImage) {
		// 获取路径
		String realPath = ServletActionContext.getServletContext().getRealPath("/" + imageFolder);
		// 获取图片类型
		String imageType = imageFileName.substring(imageFileName.lastIndexOf(".") + 1, imageFileName.length());
		// 保存图片
		File saveFile = new File(new File(realPath), renameImage + "." + imageType);
		if (!saveFile.getParentFile().exists())
			saveFile.getParentFile().mkdirs();
		try {
			FileUtils.copyFile(imageFile, saveFile);
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	// 分页处理
	public List<Template> paging(List<Template> list, Integer pageNow, Integer pageSize) {
		Integer first = pageSize * (pageNow - 1);
		Integer end = pageSize * pageNow;
		Integer listSize = list.size();
		Integer currentPageSize = listSize - first;
		if (currentPageSize >= pageSize) {
			List<Template> partList = list.subList(first, end);
			return partList;
		} else {
			List<Template> partList = list.subList(first, listSize);
			return partList;
		}
	}

	// 页面内容计数
	public Integer count(List<Template> list, Integer pageSize) {
		Integer listSize = list.size();
		Integer count = (Integer) listSize / pageSize;
		if (listSize % pageSize > 0) 
			count++;
		return count;
	}

	// 属性默认Getter/Setter
	public String getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
