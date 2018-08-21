package com.ht.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.ht.pojo.TLink;
import com.ht.pojo.TLinkExample;

public interface TLinkMapper {
    int countByExample(TLinkExample example);

    int deleteByExample(TLinkExample example);

    int deleteByPrimaryKey(Integer linkid);

    int insert(TLink record);

    int insertSelective(TLink record);

    List<TLink> selectByExample(TLinkExample example);

    TLink selectByPrimaryKey(Integer linkid);

    int updateByExampleSelective(@Param("record") TLink record, @Param("example") TLinkExample example);

    int updateByExample(@Param("record") TLink record, @Param("example") TLinkExample example);

    int updateByPrimaryKeySelective(TLink record);

    int updateByPrimaryKey(TLink record);
}