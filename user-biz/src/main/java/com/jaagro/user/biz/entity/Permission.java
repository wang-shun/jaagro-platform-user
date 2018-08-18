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
public class Permission implements Serializable {
    /**
     * 权限表
     */
    private Long id;

    /**
     * 权限编号
     */
    private String accessNumber;

    /**
     * 权限说明
     */
    private String accessIllustrate;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private Long createUser;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 修改人
     */
    private Long modifyUser;

    /**
     * 是否可用(0 不可用 1 可用)
     */
    private Boolean enabled;

}