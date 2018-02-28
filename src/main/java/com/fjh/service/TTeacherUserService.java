package com.fjh.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fjh.model.TeacherUser;

@Service("teacherUserService")
public interface TTeacherUserService {
	@Resource
	// 添加
	public int addTea(TeacherUser teacherUser);
	//ͨ删除
	public int DelTea(String id);
	//ͨ查询
	public List selectById(String id);
	//查询所有
	public  List getAllTea();
	//更新
	public int updateTea(TeacherUser teacherUser);
	
	
}
