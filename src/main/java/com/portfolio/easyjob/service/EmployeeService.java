package com.portfolio.easyjob.service;

import com.portfolio.easyjob.domain.Employee;

public interface EmployeeService {
    Employee updatePersonalData(Employee employee, Employee employeeForm);
}
