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
import com.fjh.model.TeacherUser;
import com.fjh.service.TTeacherUserService;


@RestController
@RequestMapping(value = "/teacherUser")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class TeacherUserController {
	@Autowired
	private TTeacherUserService teacherUserService;
	 
	//获取所有学生数据
	 @RequestMapping(value = "/getAllTea", method = RequestMethod.GET)
	 @GET
	 public List<TeacherUser> getAllTea(@Context HttpServletResponse request) {
		List<TeacherUser> teacherUser=new ArrayList<TeacherUser>();
		teacherUser=this.teacherUserService.getAllTea();		
		return teacherUser;
	}
	 
	//ͨ通过ID查询学生信息
	 @RequestMapping(value = "/getTeaById", method = RequestMethod.GET)
	 @POST
	 @GET
	 
	 public List<TeacherUser> getTeaById(@RequestParam final String id, @Context HttpServletResponse request) {
		String teacherno = id;
		 List<TeacherUser> teacherUser=new ArrayList<TeacherUser>();
		 if(id == "") {
			 teacherUser=this.teacherUserService.getAllTea();
		 } else {
			 teacherUser=this.teacherUserService.selectById(teacherno);
		 }
		System.out.println(teacherUser);
		return teacherUser;
	}
	 				
	//新增学生信息
	@RequestMapping(value = "/saveTeacherInfo", method = RequestMethod.POST)
	@POST
	public TeacherUser saveteacherInfo(@RequestBody TeacherUser newteacherUser, @Context HttpServletResponse request) {	
		String username = newteacherUser.getName();
		String teacherno = newteacherUser.getTeacherno();
		String password = newteacherUser.getPassword();
		System.out.println(teacherUserService.selectById(teacherno));
		if(teacherUserService.selectById(teacherno).size() == 0) {
			TeacherUser teacherUser = new TeacherUser();
			teacherUser.setName(username);
			teacherUser.setTeacherno(teacherno);
			teacherUser.setPassword(password);
			if(teacherUser.getName() != null || teacherUser.getTeacherno() != null ||teacherUser.getPassword() != null) {
				int i = this.teacherUserService.addTea(teacherUser);
				if(i>0&&username!=null){
					return teacherUser;
					}
				}
		}
		return null;
	}
	//编辑更新学生信息
	@RequestMapping(value = "/editTeacherInfo", method = RequestMethod.POST)
	@POST
	public TeacherUser editteacherInfo(@RequestBody TeacherUser editteacherUser, @Context HttpServletResponse request) {	
		String username = editteacherUser.getName();
		String teacherno = editteacherUser.getTeacherno();
		String password = editteacherUser.getPassword();
		System.out.println(teacherUserService.selectById(teacherno));
		if(teacherUserService.selectById(teacherno) != null) {
			TeacherUser teacherUser = new TeacherUser();
			teacherUser.setName(username);
			teacherUser.setTeacherno(teacherno);
			teacherUser.setPassword(password);
			if(teacherUser.getName() != null || teacherUser.getTeacherno() != null ||teacherUser.getPassword() != null) {
				int i = this.teacherUserService.updateTea(teacherUser);
				if(i>0&&username!=null){
					return teacherUser;
					}
				}
			}
				return null;
			}
	
	//删除学生信息（通过ID）
		@RequestMapping(value = "/delTeacherInfo", method = RequestMethod.POST)
		@POST
		public String delteacherInfo(@RequestBody TeacherUser delteacherUser, @Context HttpServletResponse request) {	
			String teacherno = delteacherUser.getTeacherno();
			System.out.println(teacherUserService.selectById(teacherno));
			if(teacherUserService.selectById(teacherno) != null) {
					int i = this.teacherUserService.DelTea(teacherno);
					if(i>0){
						return teacherno;
						}
					
				}
					return null;
				}
	
	
}
