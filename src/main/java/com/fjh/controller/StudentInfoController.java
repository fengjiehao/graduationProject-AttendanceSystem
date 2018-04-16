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
import org.springframework.web.bind.annotation.RestController;

import com.fjh.model.PageBean;
import com.fjh.model.StudentInfo;
import com.fjh.service.TStudentInfoService;

@RestController
@RequestMapping(value = "/studentInfo")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
//学生信息管理
public class StudentInfoController {
	@Autowired
	private TStudentInfoService studentInfoService;
	 
	//分页获取数据
	@RequestMapping(value ="/getAllStudentInfoByPage", method = RequestMethod.GET)
//	(value="currentPage",defaultValue="1",required=false)
    public List<StudentInfo>  getAllStudentInfoByPage(@RequestParam int currentPage, @Context HttpServletResponse request){
//        model.addAttribute("pagemsg", studentInfoService.findByPage(currentPage));//回显分页数据
		PageBean<StudentInfo> studentInfoPB=new PageBean<StudentInfo>();
		studentInfoPB=this.studentInfoService.findByPage(currentPage);
		List<StudentInfo> studentInfo=new ArrayList<StudentInfo>();
		studentInfo=studentInfoPB.getLists();
        return studentInfo;
    }
	
	//获取所有数据总页数
	 @RequestMapping(value = "/getTotalCount", method = RequestMethod.GET)
	 @GET
	 public int getTotalCount(@Context HttpServletResponse request) {
		int totalCount;
		totalCount=this.studentInfoService.selectCount();
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
		totalCount=this.studentInfoService.selectCountPaging(id);
		//页数有点小数加一
		if(totalCount % 8 != 0) {
			return totalCount/8+1;
		}
		return totalCount/8;
	}
	
	
	//获取所有数据
	 @RequestMapping(value = "/getAllStudentInfo", method = RequestMethod.GET)
	 @GET
	 public List<StudentInfo> getAllStudentInfo(@Context HttpServletResponse request) {
		List<StudentInfo> studentInfo=new ArrayList<StudentInfo>();
		studentInfo=this.studentInfoService.getAllStudentInfo();
		return studentInfo;
	}
	 
	//获取所有数据总数
	 @RequestMapping(value = "/getCountData", method = RequestMethod.GET)
	 @GET
	 public int getCountData(@Context HttpServletResponse request) {
		int num;
		num=this.studentInfoService.selectCount();
		return num;
	}
	 
	//ͨ通过ID查询信息
	 @RequestMapping(value = "/getStudentInfoById", method = RequestMethod.GET)
	 @POST
	 @GET
	 
	 public List<StudentInfo> getStudentInfoById(@RequestParam final String id, @Context HttpServletResponse request) {
		String StudentInfoNo = id;
		 List<StudentInfo> studentInfo=new ArrayList<StudentInfo>();
		 if(id == "") {
			 studentInfo=this.studentInfoService.getAllStudentInfo();
		 } else {
			 studentInfo=this.studentInfoService.selectById(StudentInfoNo);
		 }
		System.out.println(studentInfo);
		return studentInfo;
	}
	 
		//ͨ通过ID查询信息(分页)
	 @RequestMapping(value = "/getStudentInfoByIdPaging", method = RequestMethod.GET)
	 @POST
	 @GET
	 
	    public List<StudentInfo>  getStudentInfoByIdPaging(@RequestParam final String id,@RequestParam int currentPage, @Context HttpServletResponse request){
//       model.addAttribute("pagemsg", studentInfoService.findByPage(currentPage));//回显分页数据
		PageBean<StudentInfo> studentInfoPB=new PageBean<StudentInfo>();
		studentInfoPB=this.studentInfoService.selectByIdPaging(id, currentPage);
		List<StudentInfo> studentInfo=new ArrayList<StudentInfo>();
		studentInfo=studentInfoPB.getLists();
       return studentInfo;
   }
	 				
	//新增信息
	@RequestMapping(value = "/saveStudentInfo", method = RequestMethod.POST)
	@POST
	public StudentInfo saveStudentInfo(@RequestBody StudentInfo newstudentInfo, @Context HttpServletResponse request) {	
		String sno = newstudentInfo.getSno();
		String spassword = newstudentInfo.getSpassword();
		String sname = newstudentInfo.getSname();
		String scollege = newstudentInfo.getScollege();
		String smajor = newstudentInfo.getSmajor();
		String sclass = newstudentInfo.getSclass();
		String sgrade = newstudentInfo.getSgrade();

		System.out.println("my:"+studentInfoService.selectById(sno));
		if(studentInfoService.selectById(sno).size() == 0) {
			StudentInfo studentInfo = new StudentInfo();
			studentInfo.setSno(sno);
			studentInfo.setSpassword(spassword);
			studentInfo.setSname(sname);
			studentInfo.setScollege(scollege);
			studentInfo.setSmajor(smajor);
			studentInfo.setSclass(sclass);
			studentInfo.setSgrade(sgrade);
			
			if(studentInfo.getSno() != null || studentInfo.getSpassword() != null || studentInfo.getSname() != null || studentInfo.getScollege() != null
					|| studentInfo.getSmajor() != null || studentInfo.getSclass() != null || studentInfo.getSgrade() != null) {
				int i = this.studentInfoService.addStudentInfo(studentInfo);
				if(i>0&&studentInfo!=null){
					return studentInfo;
					}
				}
		}
		return null;
	}
	
	//编辑更新信息
	@RequestMapping(value = "/editStudentInfo", method = RequestMethod.POST)
	@POST
	public StudentInfo editStudentInfo(@RequestBody StudentInfo editStudentInfo, @Context HttpServletResponse request) {	
		String sno = editStudentInfo.getSno();
		String spassword = editStudentInfo.getSpassword();
		String sname = editStudentInfo.getSname();
		String scollege = editStudentInfo.getScollege();
		String smajor = editStudentInfo.getSmajor();
		String sclass = editStudentInfo.getSclass();
		String sgrade = editStudentInfo.getSgrade();
		
		if(studentInfoService.selectById(sno) != null) {
			StudentInfo studentInfo = new StudentInfo();
			studentInfo.setSno(sno);
			studentInfo.setSpassword(spassword);
			studentInfo.setSname(sname);
			studentInfo.setScollege(scollege);
			studentInfo.setSmajor(smajor);
			studentInfo.setSclass(sclass);
			studentInfo.setSgrade(sgrade);
			
			if(studentInfo.getSno() != null || studentInfo.getSpassword() != null || studentInfo.getSname() != null || studentInfo.getScollege() != null
					|| studentInfo.getSmajor() != null || studentInfo.getSclass() != null || studentInfo.getSgrade() != null) {
				int i = this.studentInfoService.updateStudentInfo(studentInfo);
				if(i>0&&studentInfo!=null){
					return studentInfo;
					}
				}
		}
				return null;
			}
	
	//删除信息（通过ID）
		@RequestMapping(value = "/DelStudentInfo", method = RequestMethod.POST)
		@POST
		public String DelStudentInfo(@RequestBody StudentInfo DelStudentInfo, @Context HttpServletResponse request) {	
			String StudentInfoNo = DelStudentInfo.getSno();
			System.out.println(studentInfoService.selectById(StudentInfoNo));
			if(studentInfoService.selectById(StudentInfoNo) != null) {
					int i = this.studentInfoService.DelStudentInfo(StudentInfoNo);
					if(i>0){
						return StudentInfoNo;
						}
					
				}
					return null;
				}
		
		//批量删除信息（通过ID）
		@RequestMapping(value = "/DelStudentInfoBatch", method = RequestMethod.POST)
		@POST
		@GET
		public List<StudentInfo> DelStudentInfoBatch(@RequestBody List<StudentInfo> studentInfoIdList, @Context HttpServletResponse request) {	
//			List<ClassInfo> DelClassInfoList =new ArrayList<ClassInfo>();
			int result = studentInfoService.DelStudentInfoBatch(studentInfoIdList);
			System.out.println(result);
			if(result == 1) {
				return studentInfoIdList;
			}
			return null;
		}
}
