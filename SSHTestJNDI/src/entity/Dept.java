package entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Dept entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "DEPT", schema = "YI")
public class Dept implements java.io.Serializable {

	// Fields

	private Byte deptno;
	private String dname;
	private String loc;
	//private Set<Teacher> teachers = new HashSet<Teacher>();
	// Constructors

	/** default constructor */
	public Dept() {
	}

	/** minimal constructor */
	public Dept(Byte deptno) {
		this.deptno = deptno;
	}

	/** full constructor */
	public Dept(Byte deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	// Property accessors
	@Id
	@Column(name = "DEPTNO", unique = true, nullable = false, precision = 2, scale = 0)
	public Byte getDeptno() {
		return this.deptno;
	}

	public void setDeptno(Byte deptno) {
		this.deptno = deptno;
	}

	@Column(name = "DNAME", length = 20)
	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	@Column(name = "LOC", length = 13)
	public String getLoc() {
		return this.loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "dept")
	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}*/
	
	
}