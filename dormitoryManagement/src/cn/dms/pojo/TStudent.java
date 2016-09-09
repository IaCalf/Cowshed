package cn.dms.pojo;

/**
 * 学生信息
 * TStudent entity. @author MyEclipse Persistence Tools
 */

public class TStudent implements java.io.Serializable {

	// Fields

	private Long studentid;
	private TDormbuild TDormbuild;
	private String stunum;
	private String password;
	private String name;
	private String dormname;
	private String sex;
	private String tel;

	// Constructors

	/** default constructor */
	public TStudent() {
	}

	public TStudent(String stunum, String password) {
		super();
		this.stunum = stunum;
		this.password = password;
	}

	/** minimal constructor */
	public TStudent(Long studentid) {
		this.studentid = studentid;
	}

	/** full constructor */
	public TStudent(Long studentid, TDormbuild TDormbuild, String stunum,
			String password, String name, String dormname, String sex,
			String tel) {
		this.studentid = studentid;
		this.TDormbuild = TDormbuild;
		this.stunum = stunum;
		this.password = password;
		this.name = name;
		this.dormname = dormname;
		this.sex = sex;
		this.tel = tel;
	}

	// Property accessors

	public Long getStudentid() {
		return this.studentid;
	}

	public void setStudentid(Long studentid) {
		this.studentid = studentid;
	}

	public TDormbuild getTDormbuild() {
		return this.TDormbuild;
	}

	public void setTDormbuild(TDormbuild TDormbuild) {
		this.TDormbuild = TDormbuild;
	}

	public String getStunum() {
		return this.stunum;
	}

	public void setStunum(String stunum) {
		this.stunum = stunum;
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

	public String getDormname() {
		return this.dormname;
	}

	public void setDormname(String dormname) {
		this.dormname = dormname;
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