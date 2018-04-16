package com.fjh.serviceImpl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fjh.dao.StudentInfoMapper;
import com.fjh.model.StudentInfo;
import com.fjh.model.PageBean;
import com.fjh.service.TStudentInfoService;

@Service("studentInfoService")
public class StudentInfoServiceImpl implements TStudentInfoService{
	@Resource
	private StudentInfoMapper studentInfoMapper;
	
	// 添加学生信息
	public int addStudentInfo(StudentInfo studentInfo) {
		// TODO Auto-generated method stub
		return studentInfoMapper.insert(studentInfo);
	}

	//ͨ删除学生信息
	public int DelStudentInfo(String id) {
		// TODO Auto-generated method stub
		return studentInfoMapper.deleteByPrimaryKey(id);
	}
	
	//ͨ批量删除学生信息
	public int DelStudentInfoBatch(List<StudentInfo> studentInfoList) {
		// TODO Auto-generated method stub
		StudentInfo delStudentInfo = new StudentInfo();
		int i;
		for(i = 0; i<studentInfoList.size();i++) {
			delStudentInfo = studentInfoList.get(i);
			studentInfoMapper.deleteByPrimaryKey(delStudentInfo.getSno());
			System.out.println(delStudentInfo);
		}
		if(studentInfoList.isEmpty()) {
			return 0;
		}
		return 1;
	}

	//ͨ通过ID查找学生信息
	public List selectById(String id) {
		// TODO Auto-generated method stub
		return studentInfoMapper.selectByPrimaryKeyLike(id); 
	}
	
	//ͨ通过ID查找学生信息(分页)
		public PageBean<StudentInfo> selectByIdPaging(String id, int currentPage) {
			// TODO Auto-generated method stub
			HashMap<String,Object> map1 = new HashMap<String,Object>();
	        PageBean<StudentInfo> pageBean1 = new PageBean<StudentInfo>();

	        //封装当前页数
	        pageBean1.setCurrPage(currentPage);

	        //每页显示的数据
	        int pageSize=8;
	        pageBean1.setPageSize(pageSize);

	        //封装总记录数（查询的）
	        int totalCount = studentInfoMapper.selectCountPaging(id);
	        pageBean1.setTotalCount(totalCount);

	        //封装总页数
	        double tc = totalCount;
	        Double num =Math.ceil(tc/pageSize);//向上取整
	        pageBean1.setTotalPage(num.intValue());

	        map1.put("start",(currentPage-1)*pageSize);
	        map1.put("size", pageBean1.getPageSize());
	        map1.put("id", id);
	        
	        //封装每页显示的数据
	        List<StudentInfo> lists = studentInfoMapper.selectByPrimaryKeyPaging(map1);
	        pageBean1.setLists(lists);

	        return pageBean1;
		}
	
	//获取所有学生信息
	public List getAllStudentInfo() {
		// TODO Auto-generated method stub
		return studentInfoMapper.getAllStudentInfo();
	}

	//编辑更新学生信息
	public int updateStudentInfo(StudentInfo studentInfo) {
		// TODO Auto-generated method stub
		return studentInfoMapper.updateStudentInfo(studentInfo);
	}
	
	//查询数据总数
	public int selectCount() {
        return studentInfoMapper.selectCount();
    }
	
	//查询结果的数据总数
	public int selectCountPaging(String id) {
        return studentInfoMapper.selectCountPaging(id);
    }
	
	//分页查询数据
    public PageBean<StudentInfo> findByPage(int currentPage) {
        HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<StudentInfo> pageBean = new PageBean<StudentInfo>();

        //封装当前页数
        pageBean.setCurrPage(currentPage);

        //每页显示的数据
        int pageSize=8;
        pageBean.setPageSize(pageSize);

        //封装总记录数
        int totalCount = studentInfoMapper.selectCount();
        pageBean.setTotalCount(totalCount);

        //封装总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);//向上取整
        pageBean.setTotalPage(num.intValue());

        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        //封装每页显示的数据
        List<StudentInfo> lists = studentInfoMapper.findByPage(map);
        pageBean.setLists(lists);

        return pageBean;
    }
	
}
