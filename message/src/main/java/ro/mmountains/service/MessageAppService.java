package ro.mmountains.service;

import com.google.common.base.Preconditions;
import ro.mmountains.api.IMessageApi;
import ro.mmountains.domain.Message;
import ro.mmountains.view.MessageConverter;
import ro.mmountains.view.MessageView;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by aboieriu on 7/12/16.
 */
public class MessageAppService implements IMessageAppService {

    private final IMessageApi messageApi;

    private MessageConverter messageConverter = new MessageConverter();

    public MessageAppService(IMessageApi messageApi) {
        this.messageApi = Preconditions.checkNotNull(messageApi, "messageApi must be initialized");
    }

    public List<MessageView> getAll() {
        List<Message> messageList = messageApi.getAll();
        return messageList.stream().map(message -> messageConverter.reverse(message)).collect(Collectors.toList());
    }

    public void addMessage(MessageView message) {
        Message messageToAdd = messageConverter.forward(message);
        if (messageToAdd != null) {
            messageApi.addMessage(messageToAdd);
        }
    }

    public IMessageApi getMessageApi() {
        return messageApi;
    }
}
