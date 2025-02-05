package com.company.finance_ms.application.service.transaction;

import com.company.finance_ms.application.dto.transaction.TransactionDto;
import com.company.finance_ms.domain.transaction.Transaction;
import com.company.finance_ms.port.in.usecase.transaction.TransactionUseCase;
import com.company.finance_ms.port.out.sql.transaction.TransactionRepositoryPort;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionService implements TransactionUseCase {

    private final TransactionRepositoryPort transactionRepository;

    @Override
    @Transactional
    public Transaction createTransaction(TransactionDto transactionDto) {
        Transaction transaction = new Transaction(
            null,
            transactionDto.getDescription(),
            transactionDto.getAmount(),
            transactionDto.getDate(),
            null, //createdAt será manejado por @PrePersist
            null //updatedAt será manejado por @PreUpdate
        );
        
        return transactionRepository.save(transaction);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Transaction> getTransaction(Long id) {
        return transactionRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Transaction updateTransaction(Long id, TransactionDto transactionDto) {
        return transactionRepository.findById(id)
            .map(existingTransaction -> {
                Transaction updatedTransaction = new Transaction(
                    existingTransaction.getId(),
                    transactionDto.getDescription(),
                    transactionDto.getAmount(),
                    transactionDto.getDate(),
                    existingTransaction.getCreatedAt(),
                    null // updatedAt será manejado por @PreUpdate
                );
                return transactionRepository.save(updatedTransaction);
            })
            .orElseThrow(() -> new RuntimeException("Transaction not found with id: " + id));
    }
    
} 