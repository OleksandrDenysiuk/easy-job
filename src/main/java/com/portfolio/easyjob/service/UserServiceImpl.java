package com.portfolio.easyjob.service;

import com.portfolio.easyjob.domain.Employee;
import com.portfolio.easyjob.domain.Employer;
import com.portfolio.easyjob.domain.Role;
import com.portfolio.easyjob.domain.User;
import com.portfolio.easyjob.repository.RoleRepository;
import com.portfolio.easyjob.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if (user == null) throw new UsernameNotFoundException(username);

        return user;
    }


    @Override
    public User create(User user, String status) {
        User userFromDb = userRepository.findByUsername(user.getUsername());
        String statusInUpperCase = status.toUpperCase();

        if (userFromDb != null) {
            return null;
        }

        Role userRole = roleRepository.findByName("USER");
        Role roleByStatus = roleRepository.findByName(statusInUpperCase);
        user.getRoles().add(userRole);
        user.getRoles().add(roleByStatus);
        user.setPassword(new BCryptPasswordEncoder(8).encode(user.getPassword()));
        if (statusInUpperCase.equals("EMPLOYEE")) {
            Employee employee = new Employee(user);
            user.setEmployee(employee);
        } else if (statusInUpperCase.equals("EMPLOYER")) {
            Employer employer = new Employer(user);
            user.setEmployer(employer);
        }

        userRepository.save(user);
        return null;
    }

    @Override
    public User updateAuthenticationData(User user, String username, String password) {
        user.setUsername(username);
        if (!password.isEmpty()) {
            user.setPassword(new BCryptPasswordEncoder(8).encode(password));
        }
        User updateUser = userRepository.save(user);
        return updateUser;
    }

}
