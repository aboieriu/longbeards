package ro.mmountains.impl;

import com.google.common.base.Preconditions;
import ro.mmountains.api.IMessageApi;
import ro.mmountains.domain.Message;
import ro.mmountains.repository.jpa.IMessageRepository;

import java.util.List;

/**
 * Created by aboieriu on 7/12/16.
 */
public class MessageApi implements IMessageApi {

    private final IMessageRepository messageRepository;

    public MessageApi(IMessageRepository messageRepository) {
        this.messageRepository = Preconditions.checkNotNull(messageRepository, "messageRepository must be initialized");
    }

    public IMessageRepository getMessageRepository() {
        return messageRepository;
    }

    public List<Message> getAll() {
        return messageRepository.getAll();
    }
}
