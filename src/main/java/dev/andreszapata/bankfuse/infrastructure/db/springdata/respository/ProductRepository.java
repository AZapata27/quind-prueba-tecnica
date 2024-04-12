package dev.andreszapata.bankfuse.infrastructure.db.springdata.respository;

import dev.andreszapata.bankfuse.infrastructure.db.springdata.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}