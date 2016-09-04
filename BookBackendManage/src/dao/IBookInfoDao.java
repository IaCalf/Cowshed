package dao;

import java.util.List;

import entity.BookInfo;

public interface IBookInfoDao {
	//查询结果总条数
	public int getBookInfoByNameCount(String name);
	//模糊查询
	public List<BookInfo> getNameBookInfoByPage(String name, int no, int size);
	//根据ID查询
	public BookInfo getBookInfoById(long bookId);
	//根据ID删除
	public void deleteBookInfo(BookInfo bookInfo);
	//根据ID修改
	public void updateBookInfo(BookInfo bookInfo);
	//添加书
	public void addBookInfo(BookInfo bookInfo);
}
