package org.example.travel;

import org.example.travel.factorybean.ClientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {

    @Bean
    public ClientService clientService() {
        return ClientService.createInstance();
    }

}
