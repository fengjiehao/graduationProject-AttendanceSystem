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
	//ͨ批量删除
	public int DelClassBatch(List<ClassInfo> classInfoList);
	//ͨ查询
	public List selectById(String id);
	//通过ID分页查询
	//ͨ查询
	public PageBean<ClassInfo> selectByIdPaging(String id, int currentPage);
	//查询所有
	public  List getAllClass();
	//更新
	public int updateClass(ClassInfo classInfo);
	//查询总数据总数
	public int selectCount();
	//查询结果的数据总数
	public int selectCountPaging(String id);
	//分页查询
	public PageBean<ClassInfo> findByPage(int currentPage);
}
