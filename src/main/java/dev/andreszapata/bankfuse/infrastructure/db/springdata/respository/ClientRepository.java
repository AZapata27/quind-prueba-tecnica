package dev.andreszapata.bankfuse.infrastructure.db.springdata.respository;

import dev.andreszapata.bankfuse.infrastructure.db.springdata.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}