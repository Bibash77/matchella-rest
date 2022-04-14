package com.invo.matchela.api.notification.service;

import com.invo.matchela.api.notification.Message;
import com.invo.matchela.core.BaseService;

public interface MessageService extends BaseService<Message> {

     String messageGenerator(Message message);

}
