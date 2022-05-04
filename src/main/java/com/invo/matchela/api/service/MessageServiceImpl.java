package com.invo.matchela.api.service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.invo.matchela.api.entity.Notification;
import com.invo.matchela.api.dao.MessageRepository;
import com.invo.matchela.core.authorization.user.Service.UserService;
import com.invo.matchela.core.authorization.user.User;
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
    public List<Notification> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public Notification findOne(Long id) {
        return messageRepository.getOne(id);
    }

    @Override
    public Notification save(Notification notification) {
        return messageRepository.save(notification);
    }

    @Override
    public Page<Notification> findAllPageable(Object t, Pageable pageable) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> s = objectMapper.convertValue(t, Map.class);
        s.values().removeIf(Objects::isNull);
        final NotificationSpecBuilder notificationSpecBuilder = new NotificationSpecBuilder(s);
        final Specification<Notification> specification = notificationSpecBuilder.build();
            return messageRepository.findAll(specification, pageable);
    }

    @Override
    public List<Notification> saveAll(List<Notification> list) {
        return messageRepository.saveAll(list);
    }

    public String messageGenerator(Notification notification){
        User user = userService.findById(notification.getFromId());
        notification.setStatus(Status.ACTIVE);

        switch (notification.getActionType()){
            case "ORDER":
                return "Order Code:"+ notification.getOrderCode()+". "+user.getUsername() + " has ordered "+ notification.getQuantity()+ " unit " + notification.getItemName() +". Rs "+ notification.getTransactionAmount() +" is deducted.";
            case "TOP-UP":
                return "Admin has TopUp Rs. "+ notification.getTransactionAmount() +" in " + user.getUsername() + " Account";
            case "DELIVERED":
            case  "READY":
                return "Order Code:"+ notification.getOrderCode()+" .Your Order of "+ notification.getQuantity() + " Unit " + notification.getItemName() + " is "+ notification.getActionType() + " now";
            case "CANCEL":
                if (notification.getItemName() == null) {
                    return
                        " Rs." + notification.getTransactionAmount() + " is added in" + user
                            .getUsername() + " account by Admin";
                } else {
                    return
                        user.getUsername() + " has cancel order of " + notification.getItemName() + ". Rs"
                            + notification.getTransactionAmount() + " is added in account.";
                }
        }
        return "";
    }
}
