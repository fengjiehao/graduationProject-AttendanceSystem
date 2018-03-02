package com.fjh.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fjh.dao.ClassInfoMapper;
import com.fjh.model.ClassInfo;
import com.fjh.model.PageBean;
import com.fjh.service.TClassInfoService;

@Service("classInfoService")
public class ClassInfoServiceImpl implements TClassInfoService{
	@Resource
	private ClassInfoMapper classInfoMapper;
	
	// 添加学生信息
	public int addClass(ClassInfo classInfo) {
		// TODO Auto-generated method stub
		return classInfoMapper.insert(classInfo);
	}

	//ͨ删除学生信息
	public int DelClass(String id) {
		// TODO Auto-generated method stub
		return classInfoMapper.deleteByPrimaryKey(id);
	}
	
	//ͨ批量删除学生信息
	public int DelClassBatch(List<ClassInfo> classInfoList) {
		// TODO Auto-generated method stub
		ClassInfo delClassInfo = new ClassInfo();
		int i;
		for(i = 0; i<classInfoList.size();i++) {
			delClassInfo = classInfoList.get(i);
			classInfoMapper.deleteByPrimaryKey(delClassInfo.getClassno());
			System.out.println(delClassInfo);
		}
		if(classInfoList.isEmpty()) {
			return 0;
		}
		return 1;
	}

	//ͨ通过ID查找学生信息
	public List selectById(String id) {
		// TODO Auto-generated method stub
		return classInfoMapper.selectByPrimaryKey(id); 
	}
	
	//ͨ通过ID查找学生信息(分页)
		public PageBean<ClassInfo> selectByIdPaging(String id, int currentPage) {
			// TODO Auto-generated method stub
			HashMap<String,Object> map1 = new HashMap<String,Object>();
	        PageBean<ClassInfo> pageBean1 = new PageBean<ClassInfo>();

	        //封装当前页数
	        pageBean1.setCurrPage(currentPage);

	        //每页显示的数据
	        int pageSize=8;
	        pageBean1.setPageSize(pageSize);

	        //封装总记录数（查询的）
	        int totalCount = classInfoMapper.selectCountPaging(id);
	        pageBean1.setTotalCount(totalCount);

	        //封装总页数
	        double tc = totalCount;
	        Double num =Math.ceil(tc/pageSize);//向上取整
	        pageBean1.setTotalPage(num.intValue());

	        map1.put("start",(currentPage-1)*pageSize);
	        map1.put("size", pageBean1.getPageSize());
	        map1.put("id", id);
	        
	        //封装每页显示的数据
	        List<ClassInfo> lists = classInfoMapper.selectByPrimaryKeyPaging(map1);
	        pageBean1.setLists(lists);

	        return pageBean1;
		}
	
	//获取所有学生信息
	public List getAllClass() {
		// TODO Auto-generated method stub
		return classInfoMapper.getAllClass();
	}

	//编辑更新学生信息
	public int updateClass(ClassInfo classInfo) {
		// TODO Auto-generated method stub
		return classInfoMapper.updateClass(classInfo);
	}
	
	//查询数据总数
	public int selectCount() {
        return classInfoMapper.selectCount();
    }
	
	//查询结果的数据总数
	public int selectCountPaging(String id) {
        return classInfoMapper.selectCountPaging(id);
    }
	
	//分页查询数据
    public PageBean<ClassInfo> findByPage(int currentPage) {
        HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<ClassInfo> pageBean = new PageBean<ClassInfo>();

        //封装当前页数
        pageBean.setCurrPage(currentPage);

        //每页显示的数据
        int pageSize=8;
        pageBean.setPageSize(pageSize);

        //封装总记录数
        int totalCount = classInfoMapper.selectCount();
        pageBean.setTotalCount(totalCount);

        //封装总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);//向上取整
        pageBean.setTotalPage(num.intValue());

        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        //封装每页显示的数据
        List<ClassInfo> lists = classInfoMapper.findByPage(map);
        pageBean.setLists(lists);

        return pageBean;
    }
	
}
