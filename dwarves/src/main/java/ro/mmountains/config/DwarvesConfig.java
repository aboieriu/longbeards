package ro.mmountains.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.mmountains.api.IDwarfApi;
import ro.mmountains.impl.DwarfApi;
import ro.mmountains.repository.jpa.DwarfRepository;
import ro.mmountains.repository.jpa.IDwarfJpa;
import ro.mmountains.repository.jpa.IDwarfRepository;
import ro.mmountains.service.DwarfAppService;
import ro.mmountains.service.IDwarfAppService;

/**
 * Created by aboieriu on 7/12/16.
 */
@Configuration
public class DwarvesConfig {

    @Autowired
    private IDwarfJpa dwarfJpa;

    @Bean
    public IDwarfAppService dwarfAppService() {
        return new DwarfAppService(dwarfApi());
    }

    @Bean
    public IDwarfApi dwarfApi() {
        return new DwarfApi(dwarfRepository());
    }

    @Bean
    public IDwarfRepository dwarfRepository() {
        return new DwarfRepository(dwarfJpa);
    }

    public IDwarfJpa getDwarfJpa() {
        return dwarfJpa;
    }

    public void setDwarfJpa(IDwarfJpa dwarfJpa) {
        this.dwarfJpa = dwarfJpa;
    }
}
