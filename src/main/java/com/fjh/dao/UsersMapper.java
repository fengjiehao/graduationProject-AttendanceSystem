package com.fjh.dao;

import java.util.List;

import com.fjh.model.Users;

public interface UsersMapper {
    int deleteByPrimaryKey(String user);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(String user);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
    
	public int updatePassword(Users users);
    
}