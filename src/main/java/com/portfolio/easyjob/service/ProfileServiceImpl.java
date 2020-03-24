package com.portfolio.easyjob.service;

import com.portfolio.easyjob.domain.Employee;
import com.portfolio.easyjob.domain.Employer;
import com.portfolio.easyjob.domain.User;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService{
    private final EmployeeService employeeService;
    private final EmployerService employerService;
    private final UserService userService;

    public ProfileServiceImpl(EmployeeService employeeService, EmployerService employerService, UserService userService) {
        this.employeeService = employeeService;
        this.employerService = employerService;
        this.userService = userService;
    }

    @Override
    public void update(Employee employee, Employee employeeForm, User user, String username, String password) {
        employeeService.updatePersonalData(employee,employeeForm);
        userService.updateAuthenticationData(user, username,password);
    }

    @Override
    public void update(Employer employer, Employer employerForm, User user, String username, String password) {
        employerService.updatePersonalData(employer,employerForm);
        userService.updateAuthenticationData(user, username,password);
    }
}
