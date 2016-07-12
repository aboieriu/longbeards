package ro.mmountains.api;

import ro.mmountains.domain.Message;

import java.util.List;

/**
 * Created by aboieriu on 7/12/16.
 */
public interface IMessageApi {
    List<Message> getAll();
}
