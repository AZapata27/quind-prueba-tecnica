package dev.andreszapata.bankfuse.infrastructure.db.springdata.repository;

import dev.andreszapata.bankfuse.infrastructure.db.springdata.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepositoryJpa extends JpaRepository<TransactionEntity, Long> {
}