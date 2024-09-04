package com.eleme.service;

import com.eleme.dto.EmployeeDTO;
import com.eleme.dto.EmployeeLoginDTO;
import com.eleme.dto.EmployeePageQueryDTO;
import com.eleme.entity.Employee;
import com.eleme.result.PageResult;

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
}
