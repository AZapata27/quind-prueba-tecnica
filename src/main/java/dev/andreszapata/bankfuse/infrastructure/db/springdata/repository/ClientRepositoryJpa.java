package dev.andreszapata.bankfuse.infrastructure.db.springdata.repository;

import dev.andreszapata.bankfuse.infrastructure.db.springdata.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepositoryJpa extends JpaRepository<ClientEntity, Long> {
}