package com.fjh.dao;

import java.util.HashMap;
import java.util.List;

import com.fjh.model.ClassInfo;

public interface ClassInfoMapper {
	//删除数据
	public int deleteByPrimaryKey(String classno);

    public int insert(ClassInfo record);

    public int insertSelective(ClassInfo record);
    
    public List<ClassInfo> selectByPrimaryKey(String classno);
    
    //通过学号查询，分页展示
    public List<ClassInfo> selectByPrimaryKeyPaging(HashMap<String,Object> map);

    public int updateByPrimaryKeySelective(ClassInfo record);

    public int updateByPrimaryKey(ClassInfo record);
    
    //更新数据
    public int updateClass(ClassInfo classInfo);
    
    //获取所有数据
    public List<ClassInfo> getAllClass();
    
    /**
     * 查询用户记录总数
     * @return
     */
    public int selectCount();
    
    /**
     * 查询结果总数
     * @return
     */
    public int selectCountPaging(String id);
    
    /**
     * 分页操作，调用findByPage limit分页方法
     * @param map
     * @return
     */
    public List<ClassInfo> findByPage(HashMap<String,Object> map);
}