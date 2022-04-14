package com.invo.matchela.api.notification.service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.invo.matchela.api.notification.Message;
import com.invo.matchela.api.notification.repository.MessageRepository;
import com.invo.matchela.api.user.Service.UserService;
import com.invo.matchela.api.user.User;
import com.invo.matchela.core.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    private final UserService userService;

    public MessageServiceImpl(
        MessageRepository messageRepository,
        UserService userService) {
        this.messageRepository = messageRepository;
        this.userService = userService;
    }

    @Override
    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public Message findOne(Long id) {
        return messageRepository.getOne(id);
    }

    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Page<Message> findAllPageable(Object t, Pageable pageable) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> s = objectMapper.convertValue(t, Map.class);
        s.values().removeIf(Objects::isNull);
        final NotificationSpecBuilder notificationSpecBuilder = new NotificationSpecBuilder(s);
        final Specification<Message> specification = notificationSpecBuilder.build();
            return messageRepository.findAll(specification, pageable);
    }

    @Override
    public List<Message> saveAll(List<Message> list) {
        return messageRepository.saveAll(list);
    }

    public String messageGenerator(Message message){
        User user = userService.findById(message.getFromId());
        message.setStatus(Status.ACTIVE);

        switch (message.getActionType()){
            case "ORDER":
                return "Order Code:"+message.getOrderCode()+". "+user.getUsername() + " has ordered "+ message.getQuantity()+ " unit " + message.getItemName() +". Rs "+ message.getTransactionAmount() +" is deducted.";
            case "TOP-UP":
                return "Admin has TopUp Rs. "+message.getTransactionAmount() +" in " + user.getUsername() + " Account";
            case "DELIVERED":
            case  "READY":
                return "Order Code:"+message.getOrderCode()+" .Your Order of "+ message.getQuantity() + " Unit " + message.getItemName() + " is "+ message.getActionType() + " now";
            case "CANCEL":
                if (message.getItemName() == null) {
                    return
                        " Rs." + message.getTransactionAmount() + " is added in" + user
                            .getUsername() + " account by Admin";
                } else {
                    return
                        user.getUsername() + " has cancel order of " + message.getItemName() + ". Rs"
                            + message.getTransactionAmount() + " is added in account.";
                }
        }
        return "";
    }
}