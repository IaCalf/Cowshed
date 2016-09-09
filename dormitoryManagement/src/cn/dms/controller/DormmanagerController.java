package cn.dms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.dms.pojo.TDormmanager;
import cn.dms.services.IDormmanagerService;
import cn.dms.util.PageTool;

@Controller
@RequestMapping("/dormmanager")
public class DormmanagerController {
	
	@Resource
	private IDormmanagerService dormmanagerService;
	PageTool<TDormmanager> pt = new PageTool<TDormmanager>();
	
	//分页
	@RequestMapping(value="/show/{no}", method=RequestMethod.GET)
	public ModelAndView getDormmanagerPage(@PathVariable int no){
		System.out.println("-------------us");
		pt.setTotalCount(dormmanagerService.getDormmanagerCount());
		pt.setPageno(no);
		List<TDormmanager> l = dormmanagerService.getDormmanagerByPage(pt.getPageno(), pt.getPagesize());
		pt.setPagedata(l);
		ModelAndView mv = new ModelAndView("admin/dormManager");
		mv.addObject("dpt",pt);
		return mv;
	}
	//模糊查询
	@RequestMapping(value="show/query/{no}", method=RequestMethod.POST)
	public ModelAndView getDormmanagerByName(@PathVariable int no, String searchType, String s_dormManagerText){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/dormManager");
		pt.setTotalCount(dormmanagerService.getDormmanagerCount());
		pt.setPageno(no);
		if(searchType.equals("userName")){
			pt.setPagedata(dormmanagerService.getDormmanagerByNamePage(s_dormManagerText, pt.getPageno(), pt.getPagesize()));
		}else if(searchType.equals("name")){
			pt.setPagedata(dormmanagerService.getDormmanagerByUserNamePage(s_dormManagerText, pt.getPageno(), pt.getPagesize()));
		}
			
		mv.addObject("dpt",pt);
		return mv;
	}
	//请求添加
	@RequestMapping(value="/addPage", method=RequestMethod.GET)
	public String getaddPage(Model model){
		model.addAttribute(new TDormmanager());
		return "admin/dormManagerSave";
	}
	//执行添加
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addDormmanager(TDormmanager dormmanager){
		System.out.println("开始执行添加");
		dormmanagerService.addTDormmanager(dormmanager);
		return "redirect:/dormmanager/show/1";
	}
	
	//处理修改请求
	@RequestMapping(value="/{id}/up", method=RequestMethod.GET)
	public String update(@PathVariable long id,Model model){
		model.addAttribute("dormManager",dormmanagerService.getTDormmanagerById(id));
		return "admin/dormManagerSave";
	}
	
	//执行修改
	@RequestMapping(value="/{id}/update", method=RequestMethod.POST)
	public String updateDormmanager(TDormmanager dormmanager){
		System.out.println("开始执行修改");
		dormmanagerService.updateTDormmanager(dormmanager);
		return "redirect:/dormmanager/show/1";
	}
	
	//执行删除
	@RequestMapping(value="/{id}/dele", method=RequestMethod.GET)
	public String deleteDormmanager(@PathVariable long id){
		System.out.println("开始执行删除");
		dormmanagerService.deleteTDormmanager(id);
		return "redirect:/dormmanager/show/1";
	}
}
