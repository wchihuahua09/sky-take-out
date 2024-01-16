package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SetmealDishMapper {

    /**
     *
     * @param
     * @return
     */
    List<Long>  getSetmealIdsByDishIds(List<Long> dishIds);
}
