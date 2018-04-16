package com.fjh.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fjh.model.StudentInfo;
import com.fjh.model.PageBean;

@Service("studentInfoService")
public interface TStudentInfoService {
	@Resource
	// 添加
	public int addStudentInfo(StudentInfo studentInfo);
	//ͨ删除
	public int DelStudentInfo(String id);
	//ͨ批量删除
	public int DelStudentInfoBatch(List<StudentInfo> studentInfoList);
	//ͨ查询
	public List selectById(String id);
	//通过ID分页查询
	//ͨ查询
	public PageBean<StudentInfo> selectByIdPaging(String id, int currentPage);
	//查询所有
	public  List getAllStudentInfo();
	//更新
	public int updateStudentInfo(StudentInfo studentInfo);
	//查询总数据总数
	public int selectCount();
	//查询结果的数据总数
	public int selectCountPaging(String id);
	//分页查询
	public PageBean<StudentInfo> findByPage(int currentPage);

}
