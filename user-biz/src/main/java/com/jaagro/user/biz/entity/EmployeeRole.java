package com.jaagro.user.biz.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liqiangping
 */
@Data
@Accessors(chain = true)
public class EmployeeRole implements Serializable {
    /**
     * 员工角色表ID
     */
    private Integer id;

    /**
     * 员工id
     */
    private Integer employeeId;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 创建日期
     */
    private Date createTime;

    /**
     * 修改日期
     */
    private Date modifyTime;

    /**
     * 创建人(关联用户ID)
     */
    private Integer createUserId;

    /**
     * 修改人(关联用户ID)
     */
    private Integer modifyUserId;

    /**
     * 是否可用(0 不可用 1 可用)
     */
    private Boolean enabled;

}