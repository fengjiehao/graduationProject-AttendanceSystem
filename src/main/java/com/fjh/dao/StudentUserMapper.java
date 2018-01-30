package com.fjh.dao;

import java.util.List;

import com.fjh.model.StudentUser;


public interface StudentUserMapper {
	public int deleteByPrimaryKey(String id);

	public int insert(StudentUser record);

	public int insertSelective(StudentUser record);

	public StudentUser selectByPrimaryKey(String studentno);
    
	public StudentUser selectByName(String studentno);

	public int updateByPrimaryKeySelective(StudentUser record);

	public int updateByPrimaryKey(StudentUser record);

	public int updateUserPwdByName(StudentUser studentUser);

	public int updateStu(StudentUser studentUser);

	public List<StudentUser> getAllStu();
   
}