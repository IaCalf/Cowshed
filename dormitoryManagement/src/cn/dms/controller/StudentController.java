package cn.dms.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.dms.pojo.TDormbuild;
import cn.dms.pojo.TDormmanager;
import cn.dms.pojo.TStudent;
import cn.dms.services.IDormbuildService;
import cn.dms.services.IStudentService;
import cn.dms.util.PageTool;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Resource
	private IStudentService studentService;
	@Resource
	private IDormbuildService dormbuildService;
	PageTool<TStudent> pt = new PageTool<TStudent>();
	
	//分页
	@RequestMapping(value="/show/{no}", method=RequestMethod.GET)
	public ModelAndView getTStudentPage(@PathVariable int no, HttpServletRequest request){
		request.getSession().setAttribute("dormBuildList", dormbuildService.getTDormbuildAll());
		pt.setTotalCount(studentService.getStudentCount());
		pt.setPageno(no);
		pt.setPagedata(studentService.getStudentByPage(pt.getPageno(), pt.getPagesize()));
		ModelAndView mv = new ModelAndView("admin/student");
		mv.addObject("spt",pt);
		return mv;
	}
	
	//模糊查询
	@RequestMapping(value="show/query/{no}", method=RequestMethod.POST)
	public ModelAndView getTStudentByName(@PathVariable int no, String buildToSelect, String searchType, String s_studentText){
		System.out.println(buildToSelect+", "+searchType+","+s_studentText);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/student");
		pt.setTotalCount(studentService.getStudentCount());
		pt.setPageno(no);
		Map<String, Object> map = new HashMap<String, Object>();
		if(buildToSelect.length()==0){
			map.put("dormbuildid", 0);
		}else{
			map.put("dormbuildid", Long.parseLong(buildToSelect));
		}
		map.put("no", (pt.getPageno()-1)*pt.getPagesize()+1);
		map.put("size", pt.getPageno()*pt.getPagesize());
		
		if(searchType.equals("name")){
			map.put("name", "%"+searchType+"%");
			map.put("stunum", null);
			map.put("dormname", null);
		}else if(searchType.equals("number")){
			map.put("name", null);
			map.put("stunum", "%"+searchType+"%");
			map.put("dormname", null);
		}else if(searchType.equals("dorm")){
			map.put("name", null);
			map.put("stunum", null);
			map.put("dormname", "%"+searchType+"%");
		}
		pt.setPagedata(studentService.getStudentByNamePage(map));
		mv.addObject("spt",pt);
		return mv;
	}
	
	//请求添加
	@RequestMapping(value="/addPage", method=RequestMethod.GET)
	public String getaddPage(Model model){
		model.addAttribute(new TStudent());
		model.addAttribute(new TDormbuild());
		return "admin/studentSave";
	}
	//执行添加
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addTStudent(TStudent student){
		System.out.println("开始执行添加");
		studentService.addTStudent(student);
		return "redirect:/student/show/1";
	}
	
	//处理修改请求
	@RequestMapping(value="/{id}/up", method=RequestMethod.GET)
	public String update(@PathVariable long id,Model model){
		model.addAttribute("student",studentService.getStudentById(id));
		return "admin/studentSave";
	}
	
	//执行修改
	@RequestMapping(value="/{id}/update", method=RequestMethod.POST)
	public String updateTStudent(TStudent student){
		System.out.println("开始执行修改");
		studentService.updateTStudent(student);
		return "redirect:/student/show/1";
	}
	
	//执行删除
	@RequestMapping(value="/{id}/dele", method=RequestMethod.GET)
	public String deleteTStudent(@PathVariable long id){
		System.out.println("开始执行删除");
		studentService.deleteTStudent(id);
		return "redirect:/student/show/1";
	}
}
