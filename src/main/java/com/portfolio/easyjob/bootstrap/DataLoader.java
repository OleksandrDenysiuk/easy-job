package com.portfolio.easyjob.bootstrap;

import com.portfolio.easyjob.domain.Role;
import com.portfolio.easyjob.domain.User;
import com.portfolio.easyjob.repository.RoleRepository;
import com.portfolio.easyjob.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserService userService;

    public DataLoader(RoleRepository roleRepository, UserService userService) {
        this.roleRepository = roleRepository;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        Set<Role> roles = new HashSet<>();
        roleRepository.findAll().forEach(roles::add);

        int count = roles.size();

        if(count == 0){
            loadData();
        }
    }

    private void loadData(){
        Role userRole = new Role(1L,"USER");
        Role employeeRole = new Role(2L,"EMPLOYEE");
        Role employerRole = new Role(3L,"EMPLOYER");
        roleRepository.save(userRole);
        roleRepository.save(employeeRole);
        roleRepository.save(employerRole);

        User userEmployee = new User();
        userEmployee.setUsername("AlexEE");
        userEmployee.setPassword("1");

        userService.create(userEmployee,"employee");

        User userEmployer = new User();
        userEmployer.setUsername("AlexER");
        userEmployer.setPassword("1");

        userService.create(userEmployer,"employer");
    }
}
