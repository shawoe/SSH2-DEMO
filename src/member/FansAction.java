package member;

import java.util.List;
import platform.BaseAction;

@SuppressWarnings("serial")
public class FansAction extends BaseAction {
	
	// ��������
	protected String fansName;
	protected FansService fansService;
	protected List<Fans> allFanss;

	// ��Ӻ���
	public String addFans() throws Exception {
		// ��������
		if (fansName == null || fansName.trim().length() == 0) {
			this.addFieldError("fansName", "��ѡ�����");
			return INPUT;
		}
		// ��Ӻ���
		String result = fansService.addFans(fansName);
		if (result.equals(INPUT)) {
			this.addFieldError("fansName", "�����Ѵ���");
			return INPUT;
		}
		return returnAction(result);
	}

	// �鿴���к���
	public String showAllFanss() throws Exception {
		allFanss = fansService.findAll();
		if (allFanss != null) {
			this.addActionMessage("�鿴���к��ѳɹ�");
			return SUCCESS;
		}
		this.addActionMessage("��ǰû�к���");
		return NONE;
	}

	
	// Ĭ������Getter/Setter
	public String getFansName() {
		return fansName;
	}

	public FansService getFansService() {
		return fansService;
	}

	public void setFansService(FansService fansService) {
		this.fansService = fansService;
	}

	public List<Fans> getAllFanss() {
		return allFanss;
	}

	public void setAllFanss(List<Fans> allFanss) {
		this.allFanss = allFanss;
	}

	public void setFansName(String fansName) {
		this.fansName = fansName;
	}
}
