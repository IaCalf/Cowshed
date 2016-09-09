package cn.dms.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * 宿舍楼实体类
 * TDormbuild entity. @author MyEclipse Persistence Tools
 */

public class TDormbuild implements java.io.Serializable {

	// Fields

	private Long dormbuildid;
	private String dormbuildname;
	private String dormbuilddetail;
	private Set TRecords = new HashSet(0);
	private Set TDormmanagers = new HashSet(0);
	private Set TStudents = new HashSet(0);
	private Set TDorms = new HashSet(0);

	// Constructors

	/** default constructor */
	public TDormbuild() {
	}

	/** minimal constructor */
	public TDormbuild(Long dormbuildid) {
		this.dormbuildid = dormbuildid;
	}

	/** full constructor */
	public TDormbuild(Long dormbuildid, String dormbuildname,
			String dormbuilddetail, Set TRecords, Set TDormmanagers,
			Set TStudents, Set TDorms) {
		this.dormbuildid = dormbuildid;
		this.dormbuildname = dormbuildname;
		this.dormbuilddetail = dormbuilddetail;
		this.TRecords = TRecords;
		this.TDormmanagers = TDormmanagers;
		this.TStudents = TStudents;
		this.TDorms = TDorms;
	}

	// Property accessors

	public Long getDormbuildid() {
		return this.dormbuildid;
	}

	public void setDormbuildid(Long dormbuildid) {
		this.dormbuildid = dormbuildid;
	}

	public String getDormbuildname() {
		return this.dormbuildname;
	}

	public void setDormbuildname(String dormbuildname) {
		this.dormbuildname = dormbuildname;
	}

	public String getDormbuilddetail() {
		return this.dormbuilddetail;
	}

	public void setDormbuilddetail(String dormbuilddetail) {
		this.dormbuilddetail = dormbuilddetail;
	}

	public Set getTRecords() {
		return this.TRecords;
	}

	public void setTRecords(Set TRecords) {
		this.TRecords = TRecords;
	}

	public Set getTDormmanagers() {
		return this.TDormmanagers;
	}

	public void setTDormmanagers(Set TDormmanagers) {
		this.TDormmanagers = TDormmanagers;
	}

	public Set getTStudents() {
		return this.TStudents;
	}

	public void setTStudents(Set TStudents) {
		this.TStudents = TStudents;
	}

	public Set getTDorms() {
		return this.TDorms;
	}

	public void setTDorms(Set TDorms) {
		this.TDorms = TDorms;
	}

}