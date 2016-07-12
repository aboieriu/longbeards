package ro.mmountains.repository.jpa;

import ro.mmountains.domain.Message;

import java.util.List;

/**
 * Created by aboieriu on 7/12/16.
 */
public interface IMessageRepository {
    List<Message> getAll();
    void addMessage(Message message);
}
