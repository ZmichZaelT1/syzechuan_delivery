package com.syzechuan.service;

import com.syzechuan.dto.EmployeeDTO;
import com.syzechuan.dto.EmployeeLoginDTO;
import com.syzechuan.dto.EmployeePageQueryDTO;
import com.syzechuan.entity.Employee;
import com.syzechuan.result.PageResult;

public interface EmployeeService {

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

    void save(EmployeeDTO employeeDTO);

    PageResult pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    void startOrStop(Integer status, Long id);

    Employee getById(Long id);

    void update(EmployeeDTO employeeDTO);
}
