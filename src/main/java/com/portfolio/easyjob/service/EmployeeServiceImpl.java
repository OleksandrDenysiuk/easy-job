package com.portfolio.easyjob.service;

import com.portfolio.easyjob.domain.Employee;
import com.portfolio.easyjob.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee updatePersonalData(Employee employee, Employee employeeForm) {

        employee.setFirstName(employeeForm.getFirstName());
        employee.setLastName(employeeForm.getLastName());
        employee.setEmail(employeeForm.getEmail());
        employee.setAge(employeeForm.getAge());
        employee.setStudent(employeeForm.isStudent());
        employee.setBankAccountNumber(employeeForm.getBankAccountNumber());
        employee.setAddress(employeeForm.getAddress());
        employee.setPhoneNumber(employeeForm.getPhoneNumber());

        Employee updateEmployee = employeeRepository.save(employee);

        return updateEmployee;
    }
}
