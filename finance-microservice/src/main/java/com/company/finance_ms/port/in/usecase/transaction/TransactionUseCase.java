package com.company.finance_ms.port.in.usecase.transaction;

import com.company.finance_ms.application.dto.transaction.TransactionDto;
import com.company.finance_ms.domain.transaction.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionUseCase {

    Transaction createTransaction(TransactionDto transactionDto);
    Optional<Transaction> getTransaction(Long id);
    List<Transaction> getAllTransactions();
    void deleteTransaction(Long id);
    Transaction updateTransaction(Long id, TransactionDto transactionDto);
    
} 