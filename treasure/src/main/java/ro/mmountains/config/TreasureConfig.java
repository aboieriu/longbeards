package ro.mmountains.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.mmountains.api.ITreasureApi;
import ro.mmountains.impl.TreasureApi;
import ro.mmountains.repository.jpa.ITreasureJpa;
import ro.mmountains.repository.jpa.ITreasureRepository;
import ro.mmountains.repository.jpa.TreasureRepository;
import ro.mmountains.service.ITreasureAppService;
import ro.mmountains.service.TreasureAppService;

/**
 * Created by aboieriu on 7/12/16.
 */
@Configuration
public class TreasureConfig {
    @Autowired
    private ITreasureJpa treasureJpa;

    @Bean
    public ITreasureAppService treasureAppService() {
        return new TreasureAppService(treasureApi());
    }

    @Bean
    public ITreasureApi treasureApi() {
        return new TreasureApi(treasureRepository());
    }

    @Bean
    public ITreasureRepository treasureRepository(){
        return new TreasureRepository(treasureJpa);
    }

    public ITreasureJpa getTreasureJpa() {
        return treasureJpa;
    }

    public void setTreasureJpa(ITreasureJpa treasureJpa) {
        this.treasureJpa = treasureJpa;
    }
}
