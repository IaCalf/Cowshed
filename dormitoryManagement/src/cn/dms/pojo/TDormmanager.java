package cn.dms.pojo;

/**
 * 楼层管理员信息[宿管员]
 * TDormmanager entity. @author MyEclipse Persistence Tools
 */

public class TDormmanager implements java.io.Serializable {

	// Fields

	private Long dormmanid;
	private TDormbuild TDormbuild;
	private String username;
	private String password;
	private String name;
	private String sex;
	private String tel;

	// Constructors

	/** default constructor */
	public TDormmanager() {
	}

	
	public TDormmanager(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	/** minimal constructor */
	public TDormmanager(Long dormmanid) {
		this.dormmanid = dormmanid;
	}

	/** full constructor */
	public TDormmanager(Long dormmanid, TDormbuild TDormbuild, String username,
			String password, String name, String sex, String tel) {
		this.dormmanid = dormmanid;
		this.TDormbuild = TDormbuild;
		this.username = username;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.tel = tel;
	}

	// Property accessors

	public Long getDormmanid() {
		return this.dormmanid;
	}

	public void setDormmanid(Long dormmanid) {
		this.dormmanid = dormmanid;
	}

	public TDormbuild getTDormbuild() {
		return this.TDormbuild;
	}

	public void setTDormbuild(TDormbuild TDormbuild) {
		this.TDormbuild = TDormbuild;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}