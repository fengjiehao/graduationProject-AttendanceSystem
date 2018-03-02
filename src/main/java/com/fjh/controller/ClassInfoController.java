package com.fjh.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fjh.model.ClassInfo;
import com.fjh.model.PageBean;
import com.fjh.service.TClassInfoService;

@RestController
@RequestMapping(value = "/classInfo")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class ClassInfoController {
	@Autowired
	private TClassInfoService classInfoService;
	 
	//分页获取课程数据
	@RequestMapping(value ="/getAllClassByPage", method = RequestMethod.GET)
//	(value="currentPage",defaultValue="1",required=false)
    public List<ClassInfo>  getAllClassByPage(@RequestParam int currentPage, @Context HttpServletResponse request){
//        model.addAttribute("pagemsg", classInfoService.findByPage(currentPage));//回显分页数据
		PageBean<ClassInfo> classInfoPB=new PageBean<ClassInfo>();
		classInfoPB=this.classInfoService.findByPage(currentPage);
		List<ClassInfo> classInfo=new ArrayList<ClassInfo>();
		classInfo=classInfoPB.getLists();
        return classInfo;
    }
	
	//获取所有课程数据总页数
	 @RequestMapping(value = "/getTotalCount", method = RequestMethod.GET)
	 @GET
	 public int getTotalCount(@Context HttpServletResponse request) {
		int totalCount;
		totalCount=this.classInfoService.selectCount();
		//页数有点小数加一
		if(totalCount % 8 != 0) {
			return totalCount/8+1;
		}
		return totalCount/8;
	}
	 
		//获取结果数据总页数
	 @RequestMapping(value = "/getSelectCount", method = RequestMethod.GET)
	 @GET
	 public int getSelectCount(@RequestParam final String id, @Context HttpServletResponse request) {
		int totalCount;
		totalCount=this.classInfoService.selectCountPaging(id);
		//页数有点小数加一
		if(totalCount % 8 != 0) {
			return totalCount/8+1;
		}
		return totalCount/8;
	}
	
	
	//获取所有课程数据
	 @RequestMapping(value = "/getAllClass", method = RequestMethod.GET)
	 @GET
	 public List<ClassInfo> getAllClass(@Context HttpServletResponse request) {
		List<ClassInfo> classInfo=new ArrayList<ClassInfo>();
		classInfo=this.classInfoService.getAllClass();
		return classInfo;
	}
	 
	//ͨ通过ID查询课程信息
	 @RequestMapping(value = "/getClassById", method = RequestMethod.GET)
	 @POST
	 @GET
	 
	 public List<ClassInfo> getClassById(@RequestParam final String id, @Context HttpServletResponse request) {
		String classNo = id;
		 List<ClassInfo> classInfo=new ArrayList<ClassInfo>();
		 if(id == "") {
			 classInfo=this.classInfoService.getAllClass();
		 } else {
			 classInfo=this.classInfoService.selectById(classNo);
		 }
		System.out.println(classInfo);
		return classInfo;
	}
	 
		//ͨ通过ID查询课程信息(分页)
	 @RequestMapping(value = "/getClassByIdPaging", method = RequestMethod.GET)
	 @POST
	 @GET
	 
	    public List<ClassInfo>  getClassByIdPaging(@RequestParam final String id,@RequestParam int currentPage, @Context HttpServletResponse request){
//       model.addAttribute("pagemsg", classInfoService.findByPage(currentPage));//回显分页数据
		PageBean<ClassInfo> classInfoPB=new PageBean<ClassInfo>();
		classInfoPB=this.classInfoService.selectByIdPaging(id, currentPage);
		List<ClassInfo> classInfo=new ArrayList<ClassInfo>();
		classInfo=classInfoPB.getLists();
       return classInfo;
   }
	 				
	//新增课程信息
	@RequestMapping(value = "/saveClassInfo", method = RequestMethod.POST)
	@POST
	public ClassInfo saveClassInfo(@RequestBody ClassInfo newclassInfo, @Context HttpServletResponse request) {	
		String classNo = newclassInfo.getClassno();
		String className = newclassInfo.getClassname();
		System.out.println(classInfoService.selectById(classNo));
		if(classInfoService.selectById(classNo).size() == 0) {
			ClassInfo classInfo = new ClassInfo();
			classInfo.setClassno(classNo);;
			classInfo.setClassname(className);
			if(classInfo.getClassno() != null || classInfo.getClassname() != null) {
				int i = this.classInfoService.addClass(classInfo);
				if(i>0&&classInfo!=null){
					return classInfo;
					}
				}
		}
		return null;
	}
	//编辑更新课程信息
	@RequestMapping(value = "/editClassInfo", method = RequestMethod.POST)
	@POST
	public ClassInfo editClassInfo(@RequestBody ClassInfo editclassInfo, @Context HttpServletResponse request) {	
		String classNo = editclassInfo.getClassno();
		String className = editclassInfo.getClassname();
		System.out.println(classInfoService.selectById(classNo));
		if(classInfoService.selectById(classNo) != null) {
			ClassInfo classInfo = new ClassInfo();
			classInfo.setClassno(classNo);;
			classInfo.setClassname(className);
			if(classInfo.getClassno() != null || classInfo.getClassname() != null) {
				int i = this.classInfoService.updateClass(classInfo);
				if(i>0&&classInfo!=null){
					return classInfo;
					}
				}
			}
				return null;
			}
	
	//删除课程信息（通过ID）
		@RequestMapping(value = "/DelClassInfo", method = RequestMethod.POST)
		@POST
		public String DelClassInfo(@RequestBody ClassInfo DelClassInfo, @Context HttpServletResponse request) {	
			String classNo = DelClassInfo.getClassno();
			System.out.println(classInfoService.selectById(classNo));
			if(classInfoService.selectById(classNo) != null) {
					int i = this.classInfoService.DelClass(classNo);
					if(i>0){
						return classNo;
						}
					
				}
					return null;
				}
		
		//批量删除课程信息（通过ID）
		@RequestMapping(value = "/DelClassInfoBatch", method = RequestMethod.POST)
		@POST
		@GET
		public List<ClassInfo> DelClassInfoBatch(@RequestBody List<ClassInfo> classInfoIdList, @Context HttpServletResponse request) {	
//			List<ClassInfo> DelClassInfoList =new ArrayList<ClassInfo>();
			int result = classInfoService.DelClassBatch(classInfoIdList);
			System.out.println(result);
			if(result == 1) {
				return classInfoIdList;
			}
			return null;
		}

}
