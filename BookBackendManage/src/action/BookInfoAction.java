package action;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

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
	private long id;
	private String cname;//查询关键词
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public long getTName() {
		return tName;
	}
	public void setTName(long tName) {
		this.tName = tName;
	}
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	/**
	 * 初始化首页
	 * @return
	 */
	public String getBookInfos(){
		pt.setTotalCount(bookInfoBiz.getBookInfoByNameCount(null));
		pt.setPageno(1);
		pt.setPagedata(bookInfoBiz.getNameBookInfoByPage(null, pt.getPageno(), pt.getPagesize()));
		ActionContext.getContext().getSession().put("pt", pt);
		return SUCCESS;
	}
	
	/**
	 * 分页
	 * @return
	 */
	public String getBookInfoPage(){
		if(cname != null){
			//HttpServletResponse response = (HttpServletResponse)
			//ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
			try {
				String uname=URLEncoder.encode(cname, "utf-8");//编码
				Cookie cookie = new Cookie("cookieName",uname);
				ServletActionContext.getResponse().addCookie(cookie);//获取Response并将cookie存入Cookie
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//response.addCookie(cookie);
		}
		System.out.println(cname);
		pt.setTotalCount(bookInfoBiz.getBookInfoByNameCount(cname));
		pt.setPageno(no);
		pt.setPagedata(bookInfoBiz.getNameBookInfoByPage(cname, pt.getPageno(), pt.getPagesize()));
		ActionContext.getContext().getSession().put("pt", pt);
		addActionMessage(null);//清空值
		return SUCCESS;
	}
	/**
	 * 获取书本信息
	 * @return
	 */
	public String lookBookInfo() throws InvocationTargetException{
		System.out.println("--------------------------");
		System.out.println(id);
		BookInfo book=null;
		book = bookInfoBiz.getBookInfoById(id);
		System.out.println(book.getBookName());
		ActionContext.getContext().getSession().put("b", book);
		return SUCCESS;
	}
	
	/**
	 * 添加书本
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
		getBookInfos();
		addActionMessage("添加成功！");
		return SUCCESS;
	}
	/**
	 * 修改书本
	 * @return
	 */
	public String updateBookInfo(){
		System.out.println(bookInfo.getBookId());
		Date date = new Date();       
		Timestamp nousedate = new Timestamp(date.getTime());
		BookType bType = new BookType();
		bType.setId(tName);
		bookInfo.setBookType(bType);
		bookInfo.setPublishDate(nousedate);
		bookInfo.setLastUpdatetime(nousedate);
		bookInfoBiz.updateBookInfo(bookInfo);
		getBookInfos();
		addActionMessage("修改成功！");
		return SUCCESS;
	}
	
	/**
	 * 删除书本
	 * @return
	 */
	public String deleteBookInfo(){
		bookInfoBiz.deleteBookInfo(id);
		getBookInfos();
		addActionMessage("删除成功！");
		return SUCCESS;
	}
	
	/**
	 * 查询书本
	 * @return
	 */
	/*public String getNameBookInfoByPage(){
		pt.setPageno(no);
		List<BookInfo> books = bookInfoBiz.getNameBookInfoByPage(cname, pt.getPageno(), pt.getPagesize());
		pt.setTotalCount(books.size());
		pt.setPagedata(books);
		ActionContext.getContext().getSession().put("pt", pt);
		return SUCCESS;
	}*/
}
