package com.portfolio.easyjob.service;

import com.portfolio.easyjob.domain.Employer;

public interface EmployerService {
    Employer updatePersonalData(Employer employer, Employer employerForm);
}
