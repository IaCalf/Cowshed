package action;

import util.PageTool;
import biz.ITeacherBiz;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.Dept;
import entity.Teacher;

public class TeacherAction extends ActionSupport {
	private Teacher teacher;
	private ITeacherBiz teacherBiz;
	private int no;
	private int id;
	private PageTool<Teacher> pt = new PageTool<Teacher>();
	
	public ITeacherBiz getTeacherBiz() {
		return teacherBiz;
	}

	public void setTeacherBiz(ITeacherBiz teacherBiz) {
		this.teacherBiz = teacherBiz;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	/**
	 * 初始化首页
	 */
	public String getTeacherPage(){
		pt.setTotalCount(teacherBiz.getTeacherCount());
		pt.setPagedata(teacherBiz.getTeacherPage(pt.getPageno(), pt.getPagesize()));
		ActionContext.getContext().getSession().put("pt", pt);
		
		return SUCCESS;
	}
	
	/**
	 * 上一页和下一页
	 */
	public String getPage(){
		pt.setTotalCount(teacherBiz.getTeacherCount());
		pt.setPageno(no);
		pt.setPagedata(teacherBiz.getTeacherPage(pt.getPageno(), pt.getPagesize()));
		ActionContext.getContext().getSession().put("pt", pt);
		return SUCCESS;
	}
	/**
	 * 删除教员
	 */
	public String deleteTeacher(){
		System.out.println("执行删除！");
		teacherBiz.deleteTeacher(id);
		getTeacherPage();
		return SUCCESS;
	}
	/**
	 * 添加教员
	 */
	public String addTeacher(){
		System.out.println("执行添加！");
		System.out.println(teacher.getTname());
		teacherBiz.addTeacher(teacher);
		getTeacherPage();
		return SUCCESS;
	}
	/**
	 * 修改教员
	 */
	public String updateTeacher(){
		System.out.println("执行修改！");
		System.out.println(teacher.getTname());
		//System.out.println(teacher.getDept().getDname());
		teacherBiz.updataTeacher(teacher);
		getTeacherPage();
		return SUCCESS;
	}
	
	/**
	 * 获取部门信息
	 */
	public String getSingleTeacher(){
		System.out.println(id);
		Teacher t = teacherBiz.getByNoTeacher(id);
		System.out.println(t.getTname());
		ActionContext.getContext().getSession().put("t", t);
		return SUCCESS;
	}
}
