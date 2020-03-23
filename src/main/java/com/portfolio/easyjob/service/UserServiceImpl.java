package com.portfolio.easyjob.service;

import com.portfolio.easyjob.domain.Role;
import com.portfolio.easyjob.domain.User;
import com.portfolio.easyjob.repository.RoleRepository;
import com.portfolio.easyjob.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
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
    public User create(User user) {
        User userFromDb = userRepository.findByUsername(user.getUsername());

        if (userFromDb != null) {
            return null;
        }

        Role userRole = roleRepository.findByName("USER");
        user.setRoles(Arrays.asList(userRole));
        user.setPassword(new BCryptPasswordEncoder(8).encode(user.getPassword()));
        userRepository.save(user);
        return null;
    }
}
