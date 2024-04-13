package dev.andreszapata.bankfuse.infrastructure.db.springdata.repository;

import dev.andreszapata.bankfuse.infrastructure.db.springdata.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositoryJpa extends JpaRepository<ProductEntity, Long> {
}