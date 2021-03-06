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

import com.fjh.model.StudentUser;
import com.fjh.model.TeacherUser;
import com.fjh.model.Users;
import com.fjh.service.TUsersService;

@RestController
@RequestMapping(value = "/Users")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class UsersController {
	@Autowired
	private TUsersService usersService;
	
	//ͨ登录
	 @RequestMapping(value = "/checkLogin", method = RequestMethod.GET)
	 @POST
	 @GET
	 
	 public Users checkLogin(@RequestParam final String user1,@RequestParam final String password1, @Context HttpServletResponse request) {
		 Users newUsers = new Users();
		 newUsers = this.usersService.selectById(user1);
		 System.out.println(newUsers);
		 if(newUsers != null) {
			 String password = newUsers.getPassword();
			 String userPassword = password1;
			 //通过user找到用户，再比较密码(返回password = "-1"代表密码错误)
			 System.out.println(password.equals(userPassword));
			 if(password.equals(userPassword)) {
				 return newUsers;
			 } else {
				 Users noUsers = new Users();
				 noUsers.setPassword("-1");
				 return noUsers;
			 }
		 }
		 return null;
	}
	 
	//ͨ通过ID查询信息
	 @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
	 @POST
	 @GET
	 
	 public Users getUserById(@RequestParam final String id, @Context HttpServletResponse request) {
		String user = id;
		 Users userVO= new Users();
		 userVO=this.usersService.selectById(user);
		System.out.println(userVO);
		return userVO;
	}
	 
	//更改密码
		@RequestMapping(value = "/updatePassword", method = RequestMethod.GET)
		@POST
		@GET
		public Users editteacherInfo(@RequestParam final String user, @RequestParam final String oldPassword, 
				@RequestParam final String newPassword, @Context HttpServletResponse request) {	
			Users oldUsers = new Users();
			oldUsers = this.usersService.selectById(user);
			//旧密码是否正确
			if(oldUsers.getPassword().equals(oldPassword)) {
				Users newUsers = new Users();
				newUsers = oldUsers;
				newUsers.setPassword(newPassword);
				int i = this.usersService.updatePassword(newUsers);
				if(i>0&&newUsers!=null){
					return newUsers;
					}
			}
			return null;
		}

		//获取测试数据
		 @RequestMapping(value = "/getTest", method = RequestMethod.GET)
		 @GET
		 public String getAllStu(@Context HttpServletResponse request) {		
			return "jeremy is me";
		}		
		
		//创建登陆账号
		@RequestMapping(value = "/createUser", method = RequestMethod.POST)
		@POST
		public Users createUser (@RequestBody Users users, @Context HttpServletResponse request) {
			String user = users.getUser();
			String password = users.getPassword();
			String name = users.getName();
			int ruleType = users.getRuletype();
			 Users newUsers = new Users();
			 newUsers = usersService.selectById(user);
			if(newUsers == null) {
				Users users1 = new Users();
				users1.setUser(user);
				users1.setPassword(password);
				users1.setName(name);
				users1.setRuletype(ruleType);
				if(users1.getUser() != null || users1.getPassword() != null 
						|| users1.getName() != null  || users1.getRuletype() != null ) {
					int i = usersService.insert(users1);
					if(i>0 && users1!=null){
						return users1;
						}
				}
			}
			return null;
		}		

}
