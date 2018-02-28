package com.fjh.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fjh.dao.StudentUserMapper;
import com.fjh.model.StudentUser;
import com.fjh.service.TStudentUserService;

@Service("studentUserService")
public class StudentUserServiceImpl implements TStudentUserService{
	@Resource
	private StudentUserMapper studentUserMapper;
	
	// 添加学生信息
	public int addStu(StudentUser studentUser) {
		// TODO Auto-generated method stub
		return studentUserMapper.insert(studentUser);
	}

	//ͨ删除学生信息
	public int DelStu(String id) {
		// TODO Auto-generated method stub
		return studentUserMapper.deleteByPrimaryKey(id);
	}

	//ͨ通过ID查找学生信息
	public List selectById(String id) {
		// TODO Auto-generated method stub
		return studentUserMapper.selectByPrimaryKey(id); 
	}
	
	//获取所有学生信息
	public List getAllStu() {
		// TODO Auto-generated method stub
		return studentUserMapper.getAllStu();
	}

	//编辑更新学生信息
	public int updateStu(StudentUser studentUser) {
		// TODO Auto-generated method stub
		return studentUserMapper.updateStu(studentUser);
	}
	
	/*********************************************/


}
