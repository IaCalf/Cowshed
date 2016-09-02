package biz;

import java.util.List;

import entity.BookType;

public interface IBookTypeBiz {
	//查询所有
	public List<BookType> getBookTypeAll();
	//根据name查询
	public BookType getBookTypeByName(String name);
}
