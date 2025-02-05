package com.company.finance_ms.adapter.out.sql.transaction;

import com.company.finance_ms.domain.audit.Audit;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class TransactionEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String description;
    @Min(0)
    private BigDecimal amount;
    private LocalDateTime date;
    
    @Embedded
    private Audit audit = new Audit();
    
} 