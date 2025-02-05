package com.company.finance_ms.port.out.sql.transaction;

import com.company.finance_ms.domain.transaction.Transaction;
import java.util.List;
import java.util.Optional;

public interface TransactionRepositoryPort {

    Transaction save(Transaction transaction);
    Optional<Transaction> findById(Long id);
    List<Transaction> findAll();
    void deleteById(Long id);
    
}
