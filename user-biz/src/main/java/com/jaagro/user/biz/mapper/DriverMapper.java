package com.jaagro.user.biz.mapper;

import com.jaagro.user.biz.entity.Driver;

public interface DriverMapper {
    /**
     *
     * @mbggenerated 2018-08-20
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2018-08-20
     */
    int insert(Driver record);

    /**
     *
     * @mbggenerated 2018-08-20
     */
    int insertSelective(Driver record);

    /**
     *
     * @mbggenerated 2018-08-20
     */
    Driver selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2018-08-20
     */
    int updateByPrimaryKeySelective(Driver record);

    /**
     *
     * @mbggenerated 2018-08-20
     */
    int updateByPrimaryKey(Driver record);
}