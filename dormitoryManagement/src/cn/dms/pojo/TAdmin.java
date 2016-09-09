package cn.dms.pojo;

/**
 * 管理员信息
 * TAdmin entity. @author MyEclipse Persistence Tools
 */

public class TAdmin implements java.io.Serializable {

	// Fields

	private Long adminid;
	private String username;
	private String password;
	private String name;
	private String sex;
	private String tel;

	// Constructors

	/** default constructor */
	public TAdmin() {
	}

	public TAdmin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	/** minimal constructor */
	public TAdmin(Long adminid) {
		this.adminid = adminid;
	}

	/** full constructor */
	public TAdmin(Long adminid, String username, String password, String name,
			String sex, String tel) {
		this.adminid = adminid;
		this.username = username;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.tel = tel;
	}

	// Property accessors

	public Long getAdminid() {
		return this.adminid;
	}

	public void setAdminid(Long adminid) {
		this.adminid = adminid;
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