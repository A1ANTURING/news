package com.ht.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.ht.pojo.TNews;
import com.ht.pojo.TNewsExample;

public interface TNewsMapper {
    int countByExample(TNewsExample example);

    int deleteByExample(TNewsExample example);

    int deleteByPrimaryKey(Integer newsid);

    int insert(TNews record);

    int insertSelective(TNews record);

    List<TNews> selectByExampleWithBLOBs(TNewsExample example);

    List<TNews> selectByExample(TNewsExample example);

    TNews selectByPrimaryKey(Integer newsid);

    int updateByExampleSelective(@Param("record") TNews record, @Param("example") TNewsExample example);

    int updateByExampleWithBLOBs(@Param("record") TNews record, @Param("example") TNewsExample example);

    int updateByExample(@Param("record") TNews record, @Param("example") TNewsExample example);

    int updateByPrimaryKeySelective(TNews record);

    int updateByPrimaryKeyWithBLOBs(TNews record);

    int updateByPrimaryKey(TNews record);
}