package com.eleme.service;

import com.eleme.dto.EmployeeDTO;
import com.eleme.dto.EmployeeLoginDTO;
import com.eleme.entity.Employee;

public interface EmployeeService {

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

    void save(EmployeeDTO employeeDTO);
}
