package com.invo.matchela.web.rest.controller.notification;

import com.invo.matchela.api.notification.Notification;
import com.invo.matchela.api.notification.service.MessageService;
import com.invo.matchela.core.PaginationUtils;
import com.invo.matchela.core.dto.MatchResponse;
import com.invo.matchela.core.dto.RestResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(NotificationController.API)
public class NotificationController {

    static final String API = "/v1/notification";
    private final MessageService service;
    private final Logger logger = LoggerFactory.getLogger(NotificationController.class);

    @Autowired
    public NotificationController(
        MessageService messageService
    ) {
        this.service = messageService;
    }

    @PostMapping
    public ResponseEntity<RestResponseDto> saveNotification(@RequestBody Notification notification) {
        Notification savedNotification = service.save(notification);
        if (savedNotification == null) {
            logger.error("Error saving notification.");
            return MatchResponse.failResponseBadRequest("Error saving notification");
        } else {
            return MatchResponse.successResponse(savedNotification);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponseDto> getById(@PathVariable long id) {
        return MatchResponse.successResponse(service.findOne(id));
    }

    @PostMapping(path = "/list")
    public ResponseEntity<RestResponseDto> getPageable(@RequestBody Object searchDto,
        @RequestParam("page") int page, @RequestParam("size") int size) {
        return MatchResponse.successResponse(
            service.findAllPageable(searchDto, PaginationUtils.pageable(page, size)));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<RestResponseDto> getAll() {
        return MatchResponse.successResponse(service.findAll());
    }
}
