package com.fjh.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fjh.model.StudentUser;

@Service("studentUserService")
public interface TStudentUserService {
	@Resource
	// 添加学生信息
	public int addStu(StudentUser studentUser);
	//通过id删除学生信息
	public int DelStu(String id);
	//通过id查询学生信息
	public StudentUser selectById(String id);
	//查询所有学生信息
	public  List getAllStu();
	//修改学生信息
	public int updateStu(StudentUser studentUser);
	
	
}
