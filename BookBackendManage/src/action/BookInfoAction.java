package action;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import util.PageTool;
import biz.IBookInfoBiz;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.BookInfo;
import entity.BookType;

public class BookInfoAction extends ActionSupport {
	private IBookInfoBiz bookInfoBiz;
	private BookInfo bookInfo;
	private int no;
	private int id;
	private long tName;//图书类型ID
	private PageTool<BookInfo> pt = new PageTool<BookInfo>();
	public IBookInfoBiz getBookInfoBiz() {
		return bookInfoBiz;
	}
	public void setBookInfoBiz(IBookInfoBiz bookInfoBiz) {
		this.bookInfoBiz = bookInfoBiz;
	}
	public BookInfo getBookInfo() {
		return bookInfo;
	}
	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public long getTName() {
		return tName;
	}
	public void setTName(long tName) {
		this.tName = tName;
	}
	/**
	 * 初始化首页
	 * @return
	 */
	public String getBookInfos(){
		pt.setTotalCount(bookInfoBiz.getBookInfoCount());
		pt.setPagedata(bookInfoBiz.getBookInfoByPage(pt.getPageno(), pt.getPagesize()));
		ActionContext.getContext().getSession().put("pt", pt);
		
		return SUCCESS;
	}
	
	/**
	 * 分页
	 * @return
	 */
	public String getBookInfoPage(){
		pt.setTotalCount(bookInfoBiz.getBookInfoCount());
		pt.setPageno(no);
		pt.setPagedata(bookInfoBiz.getBookInfoByPage(pt.getPageno(), pt.getPagesize()));
		ActionContext.getContext().getSession().put("pt", pt);
		return SUCCESS;
	}
	/**
	 * 获取书本信息
	 * @return
	 */
	public String lookBookInfo(){
		BookInfo book = bookInfoBiz.getBookInfoById(id);
		ActionContext.getContext().getSession().put("b", book);
		return SUCCESS;
	}
	
	/**
	 * 获取书本信息
	 * @return
	 */
	public String addBookInfo(){
		Date date = new Date();       
		Timestamp nousedate = new Timestamp(date.getTime());
		BookType bType = new BookType();
		bType.setId(tName);
		bookInfo.setBookType(bType);
		bookInfo.setPublishDate(nousedate);
		bookInfo.setLastUpdatetime(nousedate);
		bookInfoBiz.addBookInfo(bookInfo);
		return SUCCESS;
	}
}
