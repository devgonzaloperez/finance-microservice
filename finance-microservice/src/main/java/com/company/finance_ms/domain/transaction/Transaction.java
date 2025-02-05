package com.company.finance_ms.domain.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class Transaction {

    private final Long id;
    private final String description;
    private final BigDecimal amount;
    //private final TransactionType type;
    private final LocalDateTime date;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public Transaction(Long id, String description, BigDecimal amount, LocalDateTime date, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        //this.type = type;
        this.date = date;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
