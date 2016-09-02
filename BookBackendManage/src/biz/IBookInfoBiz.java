package biz;

import java.util.List;

import entity.BookInfo;

public interface IBookInfoBiz {
	//查询总条数
	public int getBookInfoCount();
	//分页查询
	public List<BookInfo> getBookInfoByPage(int no, int size);
	//模糊查询
	public List<BookInfo> getNameBookInfoByPage(String name, int no, int size);
	//根据ID查询
	public BookInfo getBookInfoById(int bookId);
	//根据ID删除
	public void deleteBookInfo(int bookId);
	//根据ID修改
	public void updateBookInfo(BookInfo bookInfo);
	//添加书
	public void addBookInfo(BookInfo bookInfo);
}
