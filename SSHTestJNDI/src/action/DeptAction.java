package action;

import util.PageTool;
import biz.IDeptBiz;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.Dept;

public class DeptAction extends ActionSupport {
	private Dept dept;
	private IDeptBiz deptBiz;
	private int no;
	private int id;
	private PageTool<Dept> pt = new PageTool<Dept>();
	
	
	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public IDeptBiz getDeptBiz() {
		return deptBiz;
	}

	public void setDeptBiz(IDeptBiz deptBiz) {
		this.deptBiz = deptBiz;
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

	
	
	/**
	 * 上一页和下一页
	 */
	public String getPage(){
		pt.setTotalCount(deptBiz.getDeptCount());
		pt.setPageno(no);
		pt.setPagedata(deptBiz.getDeptPage(pt.getPageno(), pt.getPagesize()));
		ActionContext.getContext().getSession().put("pt", pt);
		return SUCCESS;
	}
	/**
	 * 删除部门
	 */
	public String deleteDept(){
		System.out.println("执行删除！");
		deptBiz.deleteDept(id);
		getPage();
		return SUCCESS;
	}
	
	/**
	 * 修改，添加部门
	 */
	public String addOrUpdateDept(){
		System.out.println("执行！");
		deptBiz.addOrUpdateDept(dept);
		getPage();
		return SUCCESS;
	}
	/**
	 * 获取部门信息
	 */
	public String getSingleDept(){
		
		Dept d = deptBiz.getByNoDept(id);
		System.out.println(d.getDname());
		ActionContext.getContext().getSession().put("d", d);
		return SUCCESS;
	}
}
