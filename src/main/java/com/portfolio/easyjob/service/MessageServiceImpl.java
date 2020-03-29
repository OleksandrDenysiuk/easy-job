package com.portfolio.easyjob.service;


import com.portfolio.easyjob.domain.Message;
import com.portfolio.easyjob.domain.User;
import com.portfolio.easyjob.repository.MessageRepository;
import com.portfolio.easyjob.repository.RoleRepository;
import com.portfolio.easyjob.repository.TypesOfMessageRepository;
import com.portfolio.easyjob.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService{

    private final MessageRepository messageRepository;
    private final TypesOfMessageRepository typesOfMessageRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public MessageServiceImpl(MessageRepository messageRepository,
                              TypesOfMessageRepository typesOfMessageRepository,
                              UserRepository userRepository, RoleRepository roleRepository) {
        this.messageRepository = messageRepository;
        this.typesOfMessageRepository = typesOfMessageRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public Message create(User author, String type) {

        //todo: more logic answer

        Message message = new Message();
        message.setAuthor(author);
        message.setType(typesOfMessageRepository.findByName(type));

        if(type.equals("VERIFY_DOC")){
            message.setRecipient(userRepository.findByRolesEquals(roleRepository.findByName("ADMIN")));
        }

        return messageRepository.save(message);
    }

    @Override
    public Message create(User author, User recipient, String type, String content) {
        Message message = new Message();
        message.setAuthor(author);
        message.setType(typesOfMessageRepository.findByName(type));

        if(type.equals("VERIFY_RESULT")){
            message.setRecipient(recipient);
            message.setContent(content);
        }
        return null;
    }

    @Override
    public void deleteByUserAndType(User user, String type) {
        messageRepository.delete(messageRepository.findByRecipientAndType(user, typesOfMessageRepository.findByName(type)));
    }

    @Override
    public List<Message> getAllByUser(User user) {
        return messageRepository.findAllByRecipient(user);
    }

}
