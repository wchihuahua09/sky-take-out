package com.sky.mapper;

import com.sky.annotation.AutoFill;
import com.sky.entity.DishFlavor;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface DishFlavorMapper {

    /**
     * 批量插入口味数据
     * @param flavors
     */

    void insertBatch(List<DishFlavor> flavors);

    /**
     * 根据菜品id删除口味数据
     * @param DishId
     */
    @Delete("delete from sky_take_out.dish_flavor where dish_id = #{DishId}")
    void deleteByDishId(Long DishId);



    /**
     * 根据菜品集合删除口味
     * @param dishIds
     */
    void deleteByDishIds(List<Long> dishIds);

    @Select("select * from sky_take_out.dish_flavor where dish_id = #{dishId}")
    List<DishFlavor> getByDish(Long dishId);


}
