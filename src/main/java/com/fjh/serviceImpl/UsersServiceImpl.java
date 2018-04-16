package com.fjh.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fjh.dao.UsersMapper;
import com.fjh.model.Users;
import com.fjh.service.TUsersService;

@Service("usersService")
public class UsersServiceImpl implements TUsersService{
	@Resource
	private UsersMapper usersMapper;
	
	//ͨ通过ID查找学生信息
	public Users selectById(String id) {
		return usersMapper.selectByPrimaryKey(id); 
	}
	
	//更改密码
	public int updatePassword(Users users) {
		return usersMapper.updatePassword(users);
	}
	
	//新增
	public int insert(Users users) {
		return usersMapper.insert(users);
	}
}
