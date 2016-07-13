package ro.mmountains.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import ro.mmountains.service.IMessageAppService;
import ro.mmountains.view.MessageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aboieriu on 7/12/16.
 */
@RestController
@RequestMapping("/messages")
public class MessageService {
    private final Logger log = LoggerFactory.getLogger(MessageService.class);

    @Autowired
    private IMessageAppService messageAppService;

    @RequestMapping
    public List<MessageView> getAllMessages() {
        return messageAppService.getAll();
    }


    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public void addMessage(@RequestBody MessageView messageView) {
        messageAppService.addMessage(messageView);
    }

    public IMessageAppService getMessageAppService() {
        return messageAppService;
    }

    public void setMessageAppService(IMessageAppService messageAppService) {
        this.messageAppService = messageAppService;
    }
}
