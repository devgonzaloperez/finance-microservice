package com.company.finance_ms.application.dto.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class TransactionDto {
    @NotBlank
    String description;
    
    @Min(0)
    BigDecimal amount;
    
    LocalDateTime date;
} 