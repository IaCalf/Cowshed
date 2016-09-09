package cn.dms.pojo;

/**
 * 寝室信息
 * TDorm entity. @author MyEclipse Persistence Tools
 */

public class TDorm implements java.io.Serializable {

	// Fields

	private Long dormid;
	private TDormbuild TDormbuild;
	private String dormname;
	private String dormtype;
	private Long dormnumber;
	private String dormtel;

	// Constructors

	/** default constructor */
	public TDorm() {
	}

	/** minimal constructor */
	public TDorm(Long dormid) {
		this.dormid = dormid;
	}

	/** full constructor */
	public TDorm(Long dormid, TDormbuild TDormbuild, String dormname,
			String dormtype, Long dormnumber, String dormtel) {
		this.dormid = dormid;
		this.TDormbuild = TDormbuild;
		this.dormname = dormname;
		this.dormtype = dormtype;
		this.dormnumber = dormnumber;
		this.dormtel = dormtel;
	}

	// Property accessors

	public Long getDormid() {
		return this.dormid;
	}

	public void setDormid(Long dormid) {
		this.dormid = dormid;
	}

	public TDormbuild getTDormbuild() {
		return this.TDormbuild;
	}

	public void setTDormbuild(TDormbuild TDormbuild) {
		this.TDormbuild = TDormbuild;
	}

	public String getDormname() {
		return this.dormname;
	}

	public void setDormname(String dormname) {
		this.dormname = dormname;
	}

	public String getDormtype() {
		return this.dormtype;
	}

	public void setDormtype(String dormtype) {
		this.dormtype = dormtype;
	}

	public Long getDormnumber() {
		return this.dormnumber;
	}

	public void setDormnumber(Long dormnumber) {
		this.dormnumber = dormnumber;
	}

	public String getDormtel() {
		return this.dormtel;
	}

	public void setDormtel(String dormtel) {
		this.dormtel = dormtel;
	}

}