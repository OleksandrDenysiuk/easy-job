package com.portfolio.easyjob.repository;

import com.portfolio.easyjob.domain.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
