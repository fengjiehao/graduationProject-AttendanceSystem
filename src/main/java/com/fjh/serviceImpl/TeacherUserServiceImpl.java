package com.fjh.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fjh.dao.TeacherUserMapper;
import com.fjh.model.TeacherUser;
import com.fjh.service.TTeacherUserService;

@Service("teacherUserService")
public class TeacherUserServiceImpl implements TTeacherUserService{
	@Resource
	private TeacherUserMapper teacherUserMapper;
	
	// 添加学生信息
	public int addTea(TeacherUser teacherUser) {
		return teacherUserMapper.insert(teacherUser);
	}

	//ͨ删除学生信息
	public int DelTea(String id) {
		return teacherUserMapper.deleteByPrimaryKey(id);
	}

	//ͨ通过ID查找学生信息
	public List selectById(String id) {
		return teacherUserMapper.selectByPrimaryKey(id); 
	}
	
	//获取所有学生信息
	public List getAllTea() {
		return teacherUserMapper.getAllTea();
	}

	//编辑更新学生信息
	public int updateTea(TeacherUser teacherUser) {
		return teacherUserMapper.updateTea(teacherUser);
	}
	
	/*********************************************/


}
