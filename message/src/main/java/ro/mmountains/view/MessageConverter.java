package ro.mmountains.view;

import ro.mmountains.domain.Message;

/**
 * Created by aboieriu on 7/12/16.
 */
public class MessageConverter {

    public MessageView reverse(Message message) {
        if (message == null) {
            return null;
        }
        return new MessageView(message.getId(), message.getContent(), message.getRead());
    }
}
