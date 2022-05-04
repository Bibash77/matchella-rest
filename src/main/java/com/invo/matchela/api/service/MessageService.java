package com.invo.matchela.api.service;

import com.invo.matchela.api.entity.Notification;
import com.invo.matchela.core.BaseService;

public interface MessageService extends BaseService<Notification> {

     String messageGenerator(Notification notification);

}
