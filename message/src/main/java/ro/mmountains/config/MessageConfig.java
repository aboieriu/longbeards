package ro.mmountains.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.mmountains.api.IMessageApi;
import ro.mmountains.impl.MessageApi;
import ro.mmountains.repository.jpa.IMessageJpa;
import ro.mmountains.repository.jpa.IMessageRepository;
import ro.mmountains.repository.jpa.MessageRepository;
import ro.mmountains.service.IMessageAppService;
import ro.mmountains.service.MessageAppService;

/**
 * Created by aboieriu on 7/12/16.
 */

@Configuration
public class MessageConfig {

    @Autowired
    private IMessageJpa messageJpa;

    @Bean
    public IMessageAppService messageAppService() {
        return new MessageAppService(messageApi());
    }

    @Bean
    public IMessageApi messageApi() {
        return new MessageApi(messageRepository());
    }

    @Bean
    public IMessageRepository messageRepository() {
        return new MessageRepository(messageJpa);
    }
}
