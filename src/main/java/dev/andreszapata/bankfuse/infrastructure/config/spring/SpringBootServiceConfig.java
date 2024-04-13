package dev.andreszapata.bankfuse.infrastructure.config.spring;

import dev.andreszapata.bankfuse.application.service.ClienteApplicationService;
import dev.andreszapata.bankfuse.application.service.ClienteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringBootServiceConfig {


  @Bean
  public ClienteService clienteService() {

    return new ClienteApplicationService();
  }
}