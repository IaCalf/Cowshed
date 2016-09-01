package entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TEACHER", schema = "YI")
public class Teacher implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Short tno;
	private String tname;
	private String tid;
	private String gender;
	private Timestamp birthdate;
	private String job;
	private Timestamp hiredate;
	private Double sal;
	private Dept dept;
	private Short mgrno;
	private Double comm;

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** minimal constructor */
	public Teacher(Short tno, String tname) {
		this.tno = tno;
		this.tname = tname;
	}

	/** full constructor */
	public Teacher(Short tno, String tname, String tid, String gender,
			Timestamp birthdate, String job, Timestamp hiredate, Double sal,
			Dept dept, Short mgrno, Double comm) {
		this.tno = tno;
		this.tname = tname;
		this.tid = tid;
		this.gender = gender;
		this.birthdate = birthdate;
		this.job = job;
		this.hiredate = hiredate;
		this.sal = sal;
		this.dept = dept;
		this.mgrno = mgrno;
		this.comm = comm;
	}

	// Property accessors
	@Id
	@Column(name = "TNO", unique = true, nullable = false, precision = 4, scale = 0)
	public Short getTno() {
		return this.tno;
	}

	public void setTno(Short tno) {
		this.tno = tno;
	}

	@Column(name = "TNAME", nullable = false, length = 30)
	public String getTname() {
		return this.tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	@Column(name = "TID", length = 18)
	public String getTid() {
		return this.tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	@Column(name = "GENDER", length = 2)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "BIRTHDATE", length = 7)
	public Timestamp getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Timestamp birthdate) {
		this.birthdate = birthdate;
	}

	@Column(name = "JOB", length = 10)
	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Column(name = "HIREDATE", length = 7)
	public Timestamp getHiredate() {
		return this.hiredate;
	}

	public void setHiredate(Timestamp hiredate) {
		this.hiredate = hiredate;
	}

	@Column(name = "SAL", precision = 7)
	public Double getSal() {
		return this.sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	@ManyToOne(targetEntity = Dept.class,fetch = FetchType.EAGER)
	@JoinColumn(name = "DEPTNO")
	public Dept getDept() {
		return this.dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Column(name = "MGRNO", precision = 4, scale = 0)
	public Short getMgrno() {
		return this.mgrno;
	}

	public void setMgrno(Short mgrno) {
		this.mgrno = mgrno;
	}

	@Column(name = "COMM", precision = 7)
	public Double getComm() {
		return this.comm;
	}

	public void setComm(Double comm) {
		this.comm = comm;
	}

}