package member;

public abstract class FansBean {
	
	// �����û�����
	private Integer fansID;
	private String fansFollwer;
	private String fansStar;
	private String fansTime;
	private Boolean fansMutual;
	
	// Ĭ�Ϲ��췽��
	public FansBean() {
	}
	
	// ���ι��췽��
	public FansBean(Integer fansID) {
		this.setFansID(fansID);
	}

	// Ĭ������Getter/Setter
	public Integer getFansID() {
		return fansID;
	}

	public void setFansID(Integer fansID) {
		this.fansID = fansID;
	}

	public String getFansFollwer() {
		return fansFollwer;
	}

	public void setFansFollwer(String fansFollwer) {
		this.fansFollwer = fansFollwer;
	}

	public String getFansStar() {
		return fansStar;
	}

	public void setFansStar(String fansStar) {
		this.fansStar = fansStar;
	}

	public String getFansTime() {
		return fansTime;
	}

	public void setFansTime(String fansTime) {
		this.fansTime = fansTime;
	}

	public Boolean getFansMutual() {
		return fansMutual;
	}

	public void setFansMutual(Boolean fansMutual) {
		this.fansMutual = fansMutual;
	}




}