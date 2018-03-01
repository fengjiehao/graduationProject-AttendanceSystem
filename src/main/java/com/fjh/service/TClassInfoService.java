package com.fjh.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fjh.model.ClassInfo;
import com.fjh.model.PageBean;


@Service("classInfoService")
public interface TClassInfoService {
	@Resource
	// 添加
	public int addClass(ClassInfo classInfo);
	//ͨ删除
	public int DelClass(String id);
	//ͨ查询
	public List selectById(String id);
	//查询所有
	public  List getAllClass();
	//更新
	public int updateClass(ClassInfo classInfo);
	//查询数据总数
	public int selectCount();
	//分页查询数据
	public PageBean<ClassInfo> findByPage(int currentPage);
	
}
