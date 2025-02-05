package com.company.finance_ms.adapter.in.web.transaction;

import com.company.finance_ms.application.dto.transaction.TransactionDto;
import com.company.finance_ms.domain.transaction.Transaction;
import com.company.finance_ms.port.in.usecase.transaction.TransactionUseCase;
import com.company.finance_ms.port.in.web.transaction.TransactionControllerPort;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionControllerAdapter implements TransactionControllerPort {

    @Autowired
    private final TransactionUseCase transactionUseCase;

    @Override
    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@Valid @RequestBody TransactionDto transactionDto) {
        return ResponseEntity.ok(transactionUseCase.createTransaction(transactionDto));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransaction(@PathVariable Long id) {
        return transactionUseCase.getTransaction(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        return ResponseEntity.ok(transactionUseCase.getAllTransactions());
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        transactionUseCase.deleteTransaction(id);
        return ResponseEntity.ok().build();
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable Long id, @Valid @RequestBody TransactionDto transactionDto) {
        return ResponseEntity.ok(transactionUseCase.updateTransaction(id, transactionDto));
    }

} 