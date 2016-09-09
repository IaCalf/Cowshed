package cn.dms.util;

import java.util.List;

public class PageTool<T> {
	private int pageno;		//当前页
	private int pagesize=1; //每页显示条数
	private int totalCount; //总页数
	private int totalPage;	//总条数
	private List<T> pagedata;
	
	public PageTool() {
		super();
		this.pagesize=3;
		this.pageno=1;
	}
	
	public int getPageno() {
		return pageno;
	}
	public void setPageno(int pageno) {
		if(pageno <= 1){
			this.pageno = 1;
		}else if (pageno >= this.totalPage){
			this.pageno = this.totalPage;
		}else{
			this.pageno = pageno;
		}
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		if(totalCount % this.pagesize == 0){
			this.totalPage = totalCount / this.pagesize;
		}else{
			this.totalPage = totalCount / this.pagesize + 1;
		}
		this.totalCount = totalCount;
	}
	
	public int getTotalPage() {
		return totalPage;
	}
	public List<T> getPagedata() {
		return pagedata;
	}
	public void setPagedata(List<T> pagedata) {
		this.pagedata = pagedata;
	}
}
