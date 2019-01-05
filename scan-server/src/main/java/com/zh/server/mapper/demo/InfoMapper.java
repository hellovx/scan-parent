package com.zh.server.mapper.demo;

import com.zh.api.entity.demo.Info;



public interface InfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Info record);

    int insertSelective(Info record);

    Info selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Info record);

    int updateByPrimaryKey(Info record);
}