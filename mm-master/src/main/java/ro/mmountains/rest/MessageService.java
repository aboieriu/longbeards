package ro.mmountains.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ro.mmountains.domain.Message;
import ro.mmountains.service.IMessageAppService;
import ro.mmountains.view.MessageView;

import java.util.List;

/**
 * Created by aboieriu on 7/12/16.
 */
@RestController
@RequestMapping("/messages")
public class MessageService {
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
