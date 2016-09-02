package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * BookType entity. @author MyEclipse Persistence Tools
 */

public class BookType implements java.io.Serializable {

	// Fields

	private Long id;
	private String typeName;
	private Set bookInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public BookType() {
	}

	/** minimal constructor */
	public BookType(Long id, String typeName) {
		this.id = id;
		this.typeName = typeName;
	}

	/** full constructor */
	public BookType(Long id, String typeName, Set bookInfos) {
		this.id = id;
		this.typeName = typeName;
		this.bookInfos = bookInfos;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Set getBookInfos() {
		return this.bookInfos;
	}

	public void setBookInfos(Set bookInfos) {
		this.bookInfos = bookInfos;
	}

}