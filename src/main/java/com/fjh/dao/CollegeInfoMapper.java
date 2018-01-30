package com.fjh.dao;

import com.fjh.model.CollegeInfo;

public interface CollegeInfoMapper {
    int deleteByPrimaryKey(String collegeno);

    int insert(CollegeInfo record);

    int insertSelective(CollegeInfo record);

    CollegeInfo selectByPrimaryKey(String collegeno);

    int updateByPrimaryKeySelective(CollegeInfo record);

    int updateByPrimaryKey(CollegeInfo record);
}