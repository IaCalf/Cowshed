package action;

import java.util.List;

import biz.IBookTypeBiz;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.BookType;

public class BookTypeAction extends ActionSupport {
	private IBookTypeBiz bookTypeBiz;
	
	public IBookTypeBiz getBookTypeBiz() {
		return bookTypeBiz;
	}

	public void setBookTypeBiz(IBookTypeBiz bookTypeBiz) {
		this.bookTypeBiz = bookTypeBiz;
	}



	/**
	 * 进入图书添加页
	 * @return
	 */
	public String gotoAddBook(){
		System.out.println("------------------------------");
		List<BookType> bookTypeAll = bookTypeBiz.getBookTypeAll();
		ActionContext.getContext().getSession().put("bpa", bookTypeAll);
		return SUCCESS;
	}
}
