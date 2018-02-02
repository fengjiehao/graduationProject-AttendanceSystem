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
	
	// ���ѧ����Ϣ
	public int addStu(StudentUser studentUser) {
		// TODO Auto-generated method stub
		return studentUserMapper.insert(studentUser);
	}

	//ͨ��idɾ��ѧ����Ϣ
	public int DelStu(String id) {
		// TODO Auto-generated method stub
		return studentUserMapper.deleteByPrimaryKey(id);
	}

	//ͨ��id��ѯѧ����Ϣ
	public List selectById(String id) {
		// TODO Auto-generated method stub
		return studentUserMapper.selectByPrimaryKey(id); 
	}
	
	//��ѯ����ѧ����Ϣ
	public List getAllStu() {
		// TODO Auto-generated method stub
		return studentUserMapper.getAllStu();
	}

	//�޸�ѧ����Ϣ
	public int updateStu(StudentUser studentUser) {
		// TODO Auto-generated method stub
		return studentUserMapper.updateStu(studentUser);
	}
	
	/*********************************************/


}
