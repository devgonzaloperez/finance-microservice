package com.company.finance_ms.adapter.out.sql.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTransactionRepository extends JpaRepository<TransactionEntity, Long> {}
