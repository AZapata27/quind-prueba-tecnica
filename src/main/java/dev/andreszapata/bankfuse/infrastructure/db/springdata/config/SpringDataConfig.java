package dev.andreszapata.bankfuse.infrastructure.db.springdata.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableJpaRepositories(
    basePackages = "dev.andreszapata.bankfuse.infrastructure.db.springdata.respository")
@ConfigurationProperties("spring.datasource")
@EnableJpaAuditing
@EntityScan(basePackages = "dev.andreszapata.bankfuse.infrastructure.db.springdata.entity")
public class SpringDataConfig {


}