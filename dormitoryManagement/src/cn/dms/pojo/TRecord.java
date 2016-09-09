package cn.dms.pojo;

import java.sql.Timestamp;

/**
 * 学生违规记录表
 * TRecord entity. @author MyEclipse Persistence Tools
 */

public class TRecord implements java.io.Serializable {

	// Fields

	private Long recordid;
	private TDormbuild TDormbuild;
	private String studentnumber;
	private String studentname;
	private String dormname;
	private Timestamp tdate;
	private String detail;

	// Constructors

	/** default constructor */
	public TRecord() {
	}

	/** minimal constructor */
	public TRecord(Long recordid) {
		this.recordid = recordid;
	}

	/** full constructor */
	public TRecord(Long recordid, TDormbuild TDormbuild, String studentnumber,
			String studentname, String dormname, Timestamp tdate, String detail) {
		this.recordid = recordid;
		this.TDormbuild = TDormbuild;
		this.studentnumber = studentnumber;
		this.studentname = studentname;
		this.dormname = dormname;
		this.tdate = tdate;
		this.detail = detail;
	}

	// Property accessors

	public Long getRecordid() {
		return this.recordid;
	}

	public void setRecordid(Long recordid) {
		this.recordid = recordid;
	}

	public TDormbuild getTDormbuild() {
		return this.TDormbuild;
	}

	public void setTDormbuild(TDormbuild TDormbuild) {
		this.TDormbuild = TDormbuild;
	}

	public String getStudentnumber() {
		return this.studentnumber;
	}

	public void setStudentnumber(String studentnumber) {
		this.studentnumber = studentnumber;
	}

	public String getStudentname() {
		return this.studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getDormname() {
		return this.dormname;
	}

	public void setDormname(String dormname) {
		this.dormname = dormname;
	}

	public Timestamp getTdate() {
		return this.tdate;
	}

	public void setTdate(Timestamp tdate) {
		this.tdate = tdate;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}