package com.fjh.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fjh.model.StudentUser;

@Service("studentUserService")
public interface TStudentUserService {
	@Resource
	// 添加
	public int addStu(StudentUser studentUser);
	//ͨ删除
	public int DelStu(String id);
	//ͨ查询
	public List selectById(String id);
	//查询所有
	public  List getAllStu();
	//更新
	public int updateStu(StudentUser studentUser);
	
	
}
