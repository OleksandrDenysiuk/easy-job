package com.portfolio.easyjob.service;

import com.portfolio.easyjob.domain.Message;
import com.portfolio.easyjob.domain.User;

import java.util.List;


public interface MessageService {

    Message create(User author, String type);

    Message create(User author, User recipient, String type, String content);

    void deleteByUserAndType(User user, String type);

    List<Message> getAllByUser(User user);
}
