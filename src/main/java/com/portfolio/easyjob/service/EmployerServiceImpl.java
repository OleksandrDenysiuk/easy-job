package com.portfolio.easyjob.service;

import com.portfolio.easyjob.domain.Employer;
import com.portfolio.easyjob.repository.EmployerRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployerServiceImpl implements EmployerService{

    private final EmployerRepository employerRepository;

    public EmployerServiceImpl(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @Override
    public Employer updatePersonalData(Employer employer, Employer employerForm) {

        employer.setNameOfOrganization(employerForm.getNameOfOrganization());
        employer.setEmail(employerForm.getEmail());
        employer.setBankAccountNumber(employerForm.getBankAccountNumber());
        employer.setPhoneNumber(employerForm.getPhoneNumber());

        return employerRepository.save(employer);
    }
}
