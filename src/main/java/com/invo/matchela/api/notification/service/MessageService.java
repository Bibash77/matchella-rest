package com.invo.matchela.api.notification.service;

import com.invo.matchela.api.notification.Notification;
import com.invo.matchela.core.BaseService;

public interface MessageService extends BaseService<Notification> {

     String messageGenerator(Notification notification);

}
