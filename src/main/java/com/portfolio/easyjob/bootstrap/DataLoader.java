package com.portfolio.easyjob.bootstrap;

import com.portfolio.easyjob.model.Role;
import com.portfolio.easyjob.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public DataLoader(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
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
        roleRepository.save(userRole);
    }
}
