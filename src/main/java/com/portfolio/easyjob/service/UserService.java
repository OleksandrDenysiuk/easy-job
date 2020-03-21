package com.portfolio.easyjob.service;

import com.portfolio.easyjob.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User create(User user);

    //User update(User user);
}
