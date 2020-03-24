package com.portfolio.easyjob.service;

import com.portfolio.easyjob.domain.Employee;
import com.portfolio.easyjob.domain.Employer;
import com.portfolio.easyjob.domain.User;

public interface ProfileService {
    void update(Employee employee,
                Employee employeeForm,
                User user,
                String username,
                String password);

    void update(Employer employer,
                Employer employerForm,
                User user,
                String username,
                String password);

}
