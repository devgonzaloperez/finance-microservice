package com.company.finance_ms.port.in.web.transaction;

import com.company.finance_ms.application.dto.transaction.TransactionDto;
import com.company.finance_ms.domain.transaction.Transaction;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TransactionControllerPort {

    ResponseEntity<Transaction> createTransaction(TransactionDto transactionDto);
    ResponseEntity<Transaction> getTransaction(Long id);
    ResponseEntity<List<Transaction>> getAllTransactions();
    ResponseEntity<Void> deleteTransaction(Long id);
    ResponseEntity<Transaction> updateTransaction(Long id, TransactionDto transactionDto);
    
} 