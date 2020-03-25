package com.portfolio.easyjob.service;

import com.portfolio.easyjob.domain.Message;
import com.portfolio.easyjob.domain.User;

import java.util.List;


public interface MessageService {

    Message create(User author, String type);

    List<Message> getAllByUser(User user);
}
