package ro.mmountains.repository.jpa;

import com.google.common.base.Preconditions;
import ro.mmountains.domain.Message;
import ro.mmountains.repository.jpa.entity.EMessage;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by aboieriu on 7/12/16.
 */
public class MessageRepository implements IMessageRepository {

    private final IMessageJpa messageJpa;

    public MessageRepository(IMessageJpa messageJpa) {
        this.messageJpa = Preconditions.checkNotNull(messageJpa, "messageJpa must be initialized");
    }

    public List<Message> getAll() {
        List<EMessage> messages = messageJpa.findAll();
        return messages.stream().map(message -> message.convert()).collect(Collectors.toList());
    }
}
