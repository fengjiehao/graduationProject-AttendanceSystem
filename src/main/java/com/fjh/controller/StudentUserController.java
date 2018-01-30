package com.fjh.controller;

import java.util.ArrayList;
import java.util.List;

//import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import com.alibaba.fastjson.JSON;
import com.fjh.model.StudentUser;
import com.fjh.service.TStudentUserService;


@RestController
@RequestMapping(value = "/studentUser")
public class StudentUserController {
	@Autowired
	private TStudentUserService studentUserService;
	 

	 @RequestMapping(value = "/getAllStu", method = RequestMethod.GET)
	 @GET
	 @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	 public List<StudentUser> getAllStu(@Context HttpServletResponse response) {
		List<StudentUser> studentUser=new ArrayList<StudentUser>();
		studentUser=this.studentUserService.getAllStu();		
		return studentUser;
	}
	
	
	@RequestMapping(value = "/getNo", method = RequestMethod.GET)
	@GET
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public String getNo(@Context HttpServletResponse response) {	
		return "123";
	}
}
