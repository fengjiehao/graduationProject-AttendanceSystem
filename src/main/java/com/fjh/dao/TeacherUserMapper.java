package com.fjh.dao;

import java.util.List;

import com.fjh.model.TeacherUser;

public interface TeacherUserMapper {
	public int deleteByPrimaryKey(String id);

	public int insert(TeacherUser record);

	public int insertSelective(TeacherUser record);

	public List<TeacherUser> selectByPrimaryKey(String teacherno);
    
	public TeacherUser selectByName(String teacherno);

	public int updateByPrimaryKeySelective(TeacherUser record);

	public int updateByPrimaryKey(TeacherUser record);

	public int updateUserPwdByName(TeacherUser teacherUser);

	public int updateTea(TeacherUser teacherUser);

	public List<TeacherUser> getAllTea();
}