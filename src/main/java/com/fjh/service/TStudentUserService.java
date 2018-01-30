package com.fjh.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fjh.model.StudentUser;

@Service("studentUserService")
public interface TStudentUserService {
	@Resource
	// ���ѧ����Ϣ
	public int addStu(StudentUser studentUser);
	//ͨ��idɾ��ѧ����Ϣ
	public int DelStu(String id);
	//ͨ��id��ѯѧ����Ϣ
	public StudentUser selectById(String id);
	//��ѯ����ѧ����Ϣ
	public  List getAllStu();
	//�޸�ѧ����Ϣ
	public int updateStu(StudentUser studentUser);
	
	
}
