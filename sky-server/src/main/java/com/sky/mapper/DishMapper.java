package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishMapper {

    /**
     * 根据分类id查询菜品数量
     * @param categoryId
     * @return
     */
    @Select("select count(id) from sky_take_out.dish where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);

    /**
     * 新增菜品
     * @param dish
     */
    //TODO 这个自动填充不知道为什么失效了
    @AutoFill(value = OperationType.INSERT)
    void insert(Dish dish);


    /**
     * 菜品分类查询
     * @param dishPageQueryDTO
     * @return
     */
    //TODO 按名字模糊查询出错了！！！
    Page<DishVO> pageQuery(DishPageQueryDTO dishPageQueryDTO);

    /**
     * 根据主键查菜品
     * @param id
     * @return
     */
    @Select("select * from sky_take_out.dish where id = #{id}")
    Dish getById(Long id);

    @Delete("delete from sky_take_out.dish where id = #{id}")
    void deleteById(Long id);

    /**
     * 一条sql批量删除版
     * @param ids
     */
    void deleteByIds(List<Long> ids);

    /**
     * 根据ID动态修改菜品
     * @param dish
     */
    @AutoFill(value = OperationType.UPDATE)
    void update(Dish dish);
    /**
     * 根据分类id查菜品
     * @param categoryId
     * @return
     */
    @Select("select * from sky_take_out.dish where category_id = #{categoryId}")
    List<Dish> getDishesByCategoryId(Long categoryId);

    /**
     * 根据套餐id查询菜品
     * @param setmealId
     * @return
     */
    @Select("select a.* from sky_take_out.dish a left join sky_take_out.setmeal_dish b on a.id = b.dish_id where b.setmeal_id = #{setmealId}")
    List<Dish> getBySetmealId(Long setmealId);

    /**
     * 动态条件查询菜品
     * @param dish
     * @return
     */
    List<Dish> list(Dish dish);
}
