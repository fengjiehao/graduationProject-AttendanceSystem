package com.fjh.dao;

import java.util.HashMap;
import java.util.List;

import com.fjh.model.StudentInfo;

public interface StudentInfoMapper {
		//删除数据
		public int deleteByPrimaryKey(String studentInfono);

	    public int insert(StudentInfo record);

	    public int insertSelective(StudentInfo record);
	    
	    public List<StudentInfo> selectByPrimaryKey(String studentInfono);
	    
	    public List<StudentInfo> selectByPrimaryKeyLike(String studentInfono);
	    
	    //通过学号查询，分页展示
	    public List<StudentInfo> selectByPrimaryKeyPaging(HashMap<String,Object> map);

	    public int updateByPrimaryKeySelective(StudentInfo record);

	    public int updateByPrimaryKey(StudentInfo record);
	    
	    //更新数据
	    public int updateStudentInfo(StudentInfo studentInfo);
	    
	    //获取所有数据
	    public List<StudentInfo> getAllStudentInfo();
	    
	    //查询用户记录总数
	    public int selectCount();

	    //查询结果总数
	    public int selectCountPaging(String id);
	    
	    //分页操作，调用findByPage limit分页方法
	    public List<StudentInfo> findByPage(HashMap<String,Object> map);
}