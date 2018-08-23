package com.jaagro.user.biz.service.impl;

import com.jaagro.user.api.dto.request.UpdateEmpRoleDto;
import com.jaagro.user.api.service.EmployeeRoleService;
import com.jaagro.user.api.service.UserService;
import com.jaagro.user.biz.entity.EmployeeRole;
import com.jaagro.user.biz.entity.Role;
import com.jaagro.user.biz.mapper.EmployeeMapper;
import com.jaagro.user.biz.mapper.EmployeeRoleMapper;
import com.jaagro.user.biz.mapper.RoleMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import utils.BaseResponse;
import utils.ServiceResult;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author baiyiran
 */
@Service
public class EmployeeRoleServiceImpl implements EmployeeRoleService {

    @Autowired
    private EmployeeRoleMapper employeeRoleMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserService userService;

    /**
     * 新增
     *
     * @param roleIds
     * @param employeeId
     * @return
     */
    @Override
    public Map<String, Object> createEmp(Integer[] roleIds, Integer employeeId) {
        for (Integer rid : roleIds) {
            Role role = this.roleMapper.selectByPrimaryKey(rid);
            if (role == null) {
                throw new RuntimeException("角色[" + rid + "]不存在");
            }
            //新增
            EmployeeRole employeeRole = new EmployeeRole();
            employeeRole
                    .setCreateTime(new Date())
                    .setCreateUserId(this.userService.getCurrentUser().getId())
                    .setEmployeeId(employeeId)
                    .setRoleId(rid)
                    .setEnabled(true);
            this.employeeRoleMapper.insert(employeeRole);
        }
        return ServiceResult.toResult("创建成功");
    }

    /**
     * 修改
     *
     * @param dtos
     * @return
     */
    @Override
    public Map<String, Object> updateEmpRole(List<UpdateEmpRoleDto> dtos) {
        //删除
        this.employeeRoleMapper.deleteByEmpId(dtos.get(0).getEmployeeId());
        //新增
        for (UpdateEmpRoleDto dto : dtos) {
            EmployeeRole employeeRole = new EmployeeRole();
            BeanUtils.copyProperties(dto, employeeRole);
            if (this.employeeMapper.selectByPrimaryKey(employeeRole.getEmployeeId()) == null) {
                throw new RuntimeException("员工[" + dto.getEmployeeId() + "]不存在");
            }
            if (this.roleMapper.selectByPrimaryKey(employeeRole.getRoleId()) == null) {
                throw new RuntimeException("角色[" + dto.getRoleId() + "]不存在");
            }
            employeeRole
                    .setCreateUserId(userService.getCurrentUser().getId())
                    .setCreateTime(new Date())
                    .setModifyTime(new Date())
                    .setModifyUserId(userService.getCurrentUser().getId());
            this.employeeRoleMapper.insert(employeeRole);
        }
        return ServiceResult.error("修改失败");
    }
}