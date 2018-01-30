package com.fjh.dao;

import com.fjh.model.TeacherUser;

public interface TeacherUserMapper {
    int deleteByPrimaryKey(String teacherno);

    int insert(TeacherUser record);

    int insertSelective(TeacherUser record);

    TeacherUser selectByPrimaryKey(String teacherno);

    int updateByPrimaryKeySelective(TeacherUser record);

    int updateByPrimaryKey(TeacherUser record);
}