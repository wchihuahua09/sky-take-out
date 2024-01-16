package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.entity.Dish;
import org.springframework.beans.factory.annotation.Autowired;

public interface DishService {
    /**
     * 新增菜品和对应口味数据
     * @param dishDTO
     */
    public void saveWithFlavor(DishDTO dishDTO);
}
