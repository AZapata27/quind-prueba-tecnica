package dev.andreszapata.bankfuse.infrastructure.db.springdata.respository;

import dev.andreszapata.bankfuse.infrastructure.db.springdata.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}