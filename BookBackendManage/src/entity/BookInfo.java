package entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * BookInfo entity. @author MyEclipse Persistence Tools
 */

public class BookInfo implements java.io.Serializable {

	// Fields

	private Long bookId;
	private BookType bookType;
	private String bookCode;
	private String bookName;
	private String bookAuthor;
	private String publishPress;
	private Timestamp publishDate;
	private BigDecimal isBorrow;
	private String createdby;
	private Timestamp creationTime;
	private Timestamp lastUpdatetime;

	// Constructors

	/** default constructor */
	public BookInfo() {
	}

	/** full constructor */
	public BookInfo(Long bookId, BookType bookType, String bookCode,
			String bookName, String bookAuthor, String publishPress,
			Timestamp publishDate, BigDecimal isBorrow, String createdby,
			Timestamp creationTime, Timestamp lastUpdatetime) {
		this.bookId = bookId;
		this.bookType = bookType;
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.publishPress = publishPress;
		this.publishDate = publishDate;
		this.isBorrow = isBorrow;
		this.createdby = createdby;
		this.creationTime = creationTime;
		this.lastUpdatetime = lastUpdatetime;
	}

	// Property accessors

	public Long getBookId() {
		return this.bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public BookType getBookType() {
		return this.bookType;
	}

	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}

	public String getBookCode() {
		return this.bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return this.bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getPublishPress() {
		return this.publishPress;
	}

	public void setPublishPress(String publishPress) {
		this.publishPress = publishPress;
	}

	public Timestamp getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(Timestamp publishDate) {
		this.publishDate = publishDate;
	}

	public BigDecimal getIsBorrow() {
		return this.isBorrow;
	}

	public void setIsBorrow(BigDecimal isBorrow) {
		this.isBorrow = isBorrow;
	}

	public String getCreatedby() {
		return this.createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Timestamp getCreationTime() {
		return this.creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	public Timestamp getLastUpdatetime() {
		return this.lastUpdatetime;
	}

	public void setLastUpdatetime(Timestamp lastUpdatetime) {
		this.lastUpdatetime = lastUpdatetime;
	}

}