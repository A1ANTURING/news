package com.ht.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.ht.pojo.TNewstype;
import com.ht.pojo.TNewstypeExample;

public interface TNewstypeMapper {
    int countByExample(TNewstypeExample example);

    int deleteByExample(TNewstypeExample example);

    int deleteByPrimaryKey(Integer newstypeid);

    int insert(TNewstype record);

    int insertSelective(TNewstype record);

    List<TNewstype> selectByExample(TNewstypeExample example);

    TNewstype selectByPrimaryKey(Integer newstypeid);

    int updateByExampleSelective(@Param("record") TNewstype record, @Param("example") TNewstypeExample example);

    int updateByExample(@Param("record") TNewstype record, @Param("example") TNewstypeExample example);

    int updateByPrimaryKeySelective(TNewstype record);

    int updateByPrimaryKey(TNewstype record);
}