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
	
	// ��������
	protected IUserDAO userDAO;
	protected String currentUser;
	
	// Ĭ�Ϲ��췽��
	protected BaseService(){
		currentUser = SessionContext.getSessionValue("currentUser");
	}
	
	// ���õ�ǰ�û�
	public boolean recordCurrentUser(String userName) {
		return SessionContext.setSessionValue("currentUser", userName);
	}
	
	// �Ƴ���ǰ�û�
	public boolean removeCurrentUser() {
		return SessionContext.removeSessionValue("currentUser");
	}
	
	// ���ϵͳʱ��
	public String referCurrentDate() {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return simpleDateFormat.format(date);		
	}
	
	// �ϴ�ͼƬ
	public boolean uploadImage(File imageFile, String imageFileName, String imageContentType, String imageFolder, String renameImage) {
		// ��ȡ·��
		String realPath = ServletActionContext.getServletContext().getRealPath("/" + imageFolder);
		// ��ȡͼƬ����
		String imageType = imageFileName.substring(imageFileName.lastIndexOf(".") + 1, imageFileName.length());
		// ����ͼƬ
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
	
	// ��ҳ����
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

	// ҳ�����ݼ���
	public Integer count(List<Template> list, Integer pageSize) {
		Integer listSize = list.size();
		Integer count = (Integer) listSize / pageSize;
		if (listSize % pageSize > 0) 
			count++;
		return count;
	}

	// ����Ĭ��Getter/Setter
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
