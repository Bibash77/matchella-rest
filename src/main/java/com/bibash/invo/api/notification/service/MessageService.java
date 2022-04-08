package com.bibash.invo.api.notification.service;

import com.bibash.invo.api.notification.Message;
import com.bibash.invo.core.BaseService;

public interface MessageService extends BaseService<Message> {

     String messageGenerator(Message message);

}
