package com.company.finance_ms.adapter.out.sql.transaction;

import com.company.finance_ms.domain.audit.Audit;
import com.company.finance_ms.domain.transaction.Transaction;
import com.company.finance_ms.port.out.sql.transaction.TransactionRepositoryPort;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TransactionRepositoryAdapter implements TransactionRepositoryPort {

    @Autowired
    private final JpaTransactionRepository repository;

    @Override
    public Transaction save(Transaction transaction) {
        TransactionEntity entity = mapToEntity(transaction);
        TransactionEntity savedEntity = repository.save(entity);
        return mapToDomain(savedEntity);
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        return repository.findById(id).map((entity) -> mapToDomain(entity));
    }

    @Override
    public List<Transaction> findAll() {
        return repository.findAll().stream().map((entity) -> mapToDomain(entity)).toList();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    private TransactionEntity mapToEntity(Transaction transaction) {
        TransactionEntity entity = new TransactionEntity(
            transaction.getId(),
            transaction.getDescription(),
            transaction.getAmount(),
            transaction.getDate(),
            new Audit()
        );
        
        if (transaction.getId() != null) {
            entity.getAudit().setCreatedAt(transaction.getCreatedAt());
            entity.getAudit().setUpdatedAt(transaction.getUpdatedAt());
        }
        
        return entity;
    }

    private Transaction mapToDomain(TransactionEntity entity) {
        return new Transaction(
            entity.getId(),
            entity.getDescription(),
            entity.getAmount(),
            entity.getDate(),
            entity.getAudit().getCreatedAt(),
            entity.getAudit().getUpdatedAt()
        );
    }

}
