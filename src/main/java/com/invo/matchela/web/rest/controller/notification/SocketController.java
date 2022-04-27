package com.invo.matchela.web.rest.controller.notification;

import com.invo.matchela.api.notification.Notification;
import com.invo.matchela.api.notification.service.MessageService;
import com.invo.matchela.authorization.user.Service.UserService;
import com.invo.matchela.core.dto.RestResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SocketController {

    private static final String API = "/socket-publisher/";
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final MessageService service;
    private final UserService userService;
    private final Logger logger = LoggerFactory.getLogger(SocketController.class);

    public SocketController(
        SimpMessagingTemplate simpMessagingTemplate,
        MessageService service, UserService userService) {
        this.simpMessagingTemplate = simpMessagingTemplate;
        this.service = service;
        this.userService = userService;
    }

    @MessageMapping("/send/message")
    public ResponseEntity<?> usingSocketMessaging(@RequestBody Notification notification) {
            if (ObjectUtils.isEmpty(notification.getToRole()) && ObjectUtils.isEmpty(notification.getToId())) {
                logger.error("Error saving message {}", notification);
                return new RestResponseDto().failureModel("Error saving message");
            }
            String api = SocketController.API;
            if(!ObjectUtils.isEmpty(notification.getToId())){
                api = api.concat("/"+ notification.getToId());
            }
           if(!ObjectUtils.isEmpty(notification.getToRole())){
           api = api.concat("/"+ notification.getToRole());
          }
        notification.setMessage(service.messageGenerator(notification));
        simpMessagingTemplate.convertAndSend(api, notification);
        return new RestResponseDto().successModel(service.save(notification));
    }
}
