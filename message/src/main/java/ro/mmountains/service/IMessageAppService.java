package ro.mmountains.service;

import ro.mmountains.view.MessageView;

import java.util.List;

/**
 * Created by aboieriu on 7/12/16.
 */
public interface IMessageAppService {
    List<MessageView> getAll();
}
