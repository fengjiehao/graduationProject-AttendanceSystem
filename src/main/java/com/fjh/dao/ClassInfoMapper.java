package com.fjh.dao;

import java.util.HashMap;
import java.util.List;

import com.fjh.model.ClassInfo;

public interface ClassInfoMapper {
	public int deleteByPrimaryKey(String classno);

    public int insert(ClassInfo record);

    public int insertSelective(ClassInfo record);
    
    public List<ClassInfo> selectByPrimaryKey(String classno);

    public int updateByPrimaryKeySelective(ClassInfo record);

    public int updateByPrimaryKey(ClassInfo record);
    
    public int updateClass(ClassInfo classInfo);
    
    public List<ClassInfo> getAllClass();
    
    /**
     * 查询用户记录总数
     * @return
     */
    public int selectCount();
    
    /**
     * 分页操作，调用findByPage limit分页方法
     * @param map
     * @return
     */
    public List<ClassInfo> findByPage(HashMap<String,Object> map);
}