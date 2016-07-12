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
        return new MessageView(message.getId(), message.getContent());
    }

    public Message forward(MessageView messageView) {
        if (messageView == null) {
            return null;
        }
        return new Message(messageView.getId(), messageView.getContent());
    }
}
