package com.fjh.dao;

import java.util.List;

import com.fjh.model.Users;

public interface UsersMapper {
	public int deleteByPrimaryKey(String user);

	public int insert(Users users);

	public int insertSelective(Users record);

	public Users selectByPrimaryKey(String user);

	public int updateByPrimaryKeySelective(Users record);

	public int updateByPrimaryKey(Users record);
    
	public int updatePassword(Users users);
    
}