package dev.andreszapata.bankfuse.infrastructure.config.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringBootServiceConfig {


  @Bean
  public UserService userService(UserRepository userRepository) {

    return new UserService(userRepository);
  }
}