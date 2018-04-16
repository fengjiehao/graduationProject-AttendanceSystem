package com.fjh.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fjh.model.Users;

@Service("usersService")
public interface TUsersService {
	@Resource

	//ͨ查询
	public Users selectById(String id);
	
	//修改密码
	public int updatePassword(Users users);
	
	//新增
	public int insert(Users users);
}
