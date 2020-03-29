package com.portfolio.easyjob.repository;

import com.portfolio.easyjob.domain.Message;
import com.portfolio.easyjob.domain.TypeOfMessage;
import com.portfolio.easyjob.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {
    List<Message> findAllByRecipient(User user);

    Message findByRecipientAndType(User user, TypeOfMessage type);
}
