package com.portfolio.easyjob.bootstrap;

import com.portfolio.easyjob.domain.Role;
import com.portfolio.easyjob.domain.TypeOfMessage;
import com.portfolio.easyjob.domain.User;
import com.portfolio.easyjob.repository.RoleRepository;
import com.portfolio.easyjob.repository.TypesOfMessageRepository;
import com.portfolio.easyjob.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserService userService;
    private final TypesOfMessageRepository typesOfMessageRepository;

    public DataLoader(RoleRepository roleRepository, UserService userService, TypesOfMessageRepository typesOfMessageRepository) {
        this.roleRepository = roleRepository;
        this.userService = userService;
        this.typesOfMessageRepository = typesOfMessageRepository;
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
        Role adminRole = new Role(4L,"ADMIN");
        roleRepository.save(userRole);
        roleRepository.save(employeeRole);
        roleRepository.save(employerRole);
        roleRepository.save(adminRole);

        TypeOfMessage verifyDocTypeMessage = new TypeOfMessage(1L,"VERIFY_DOC");

        typesOfMessageRepository.save(verifyDocTypeMessage);

        User userEmployee = new User();
        userEmployee.setUsername("AlexEE");
        userEmployee.setPassword("1");

        userService.create(userEmployee,"employee");

        User userEmployer = new User();
        userEmployer.setUsername("AlexER");
        userEmployer.setPassword("1");

        userService.create(userEmployer,"employer");

        User userAdmin = new User();
        userAdmin.setUsername("admin");
        userAdmin.setPassword("1");

        userService.create(userAdmin,"admin");
    }
}
