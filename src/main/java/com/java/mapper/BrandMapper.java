package com.java.mapper;

import com.java.pojo.Brand;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {

    @Select("select * from brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();
}
