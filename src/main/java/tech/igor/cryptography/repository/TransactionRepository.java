package tech.igor.cryptography.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.igor.cryptography.entity.TransactionEntity;

public interface TransactionRepository  extends JpaRepository<TransactionEntity, Long> {}
