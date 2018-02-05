package com.fjh.controller;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

//import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.alibaba.fastjson.JSON;
import com.fjh.model.StudentUser;
import com.fjh.service.TStudentUserService;


@RestController
@RequestMapping(value = "/studentUser")
public class StudentUserController {
	@Autowired
	private TStudentUserService studentUserService;
	 
	//获取初始化学生信息数据表
	 @RequestMapping(value = "/getAllStu", method = RequestMethod.GET)
	 @GET
	 @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	 public List<StudentUser> getAllStu(@Context HttpServletResponse request) {
		List<StudentUser> studentUser=new ArrayList<StudentUser>();
		studentUser=this.studentUserService.getAllStu();		
		return studentUser;
	}
	 
	//通过学号查询学生信息
	 @RequestMapping(value = "/getStuById", method = RequestMethod.GET)
	 @POST
	 @GET
	 @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	 public List<StudentUser> getStuById(@RequestParam final String id, @Context HttpServletResponse request) {
		String studentno = id;
		 List<StudentUser> studentUser=new ArrayList<StudentUser>();
		 if(id == "") {
			 studentUser=this.studentUserService.getAllStu();
		 } else {
			 studentUser=this.studentUserService.selectById(studentno);
		 }
		System.out.println(studentUser);
		return studentUser;
	}
	 				
	//新增学生信息
	 			//接收数据为JSON，参数前需要添加@RequestBody
	@RequestMapping(value = "/saveStudentInfo", method = RequestMethod.POST)
	@POST
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public StudentUser saveStudentInfo(@RequestBody StudentUser newStudentUser, @Context HttpServletResponse request) {	
		String username = newStudentUser.getName();
		String studentno = newStudentUser.getStudentno();
		String password = newStudentUser.getPassword();
		System.out.println(studentUserService.selectById(studentno));
		if(studentUserService.selectById(studentno).size() == 0) {
			StudentUser studentUser = new StudentUser();
			studentUser.setName(username);
			studentUser.setStudentno(studentno);
			studentUser.setPassword(password);
			if(studentUser.getName() != null || studentUser.getStudentno() != null ||studentUser.getPassword() != null) {
				int i = this.studentUserService.addStu(studentUser);
				if(i>0&&username!=null){
					return studentUser;
					}
				}
		}
		return null;
	}
	//修改学生信息
	@RequestMapping(value = "/editStudentInfo", method = RequestMethod.POST)
	@POST
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public StudentUser editStudentInfo(@RequestBody StudentUser editStudentUser, @Context HttpServletResponse request) {	
		String username = editStudentUser.getName();
		String studentno = editStudentUser.getStudentno();
		String password = editStudentUser.getPassword();
		System.out.println(studentUserService.selectById(studentno));
		if(studentUserService.selectById(studentno) != null) {
			StudentUser studentUser = new StudentUser();
			studentUser.setName(username);
			studentUser.setStudentno(studentno);
			studentUser.setPassword(password);
			if(studentUser.getName() != null || studentUser.getStudentno() != null ||studentUser.getPassword() != null) {
				int i = this.studentUserService.updateStu(studentUser);
				if(i>0&&username!=null){
					return studentUser;
					}
				}
			}
				return null;
			}
	
	//删除学生信息
		@RequestMapping(value = "/delStudentInfo", method = RequestMethod.POST)
		@POST
		@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
		public String delStudentInfo(@RequestBody StudentUser delStudentUser, @Context HttpServletResponse request) {	
			String studentno = delStudentUser.getStudentno();
			System.out.println(studentUserService.selectById(studentno));
			if(studentUserService.selectById(studentno) != null) {
					int i = this.studentUserService.DelStu(studentno);
					if(i>0){
						return studentno;
						}
					
				}
					return null;
				}
	
	
}
