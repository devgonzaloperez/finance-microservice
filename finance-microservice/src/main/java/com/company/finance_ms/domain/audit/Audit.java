package com.company.finance_ms.domain.audit;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;

@Embeddable
public class Audit {

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    //Eventos del Ciclo de Vida.
    @PrePersist
    public void prePersist(){
        System.out.println("[LIFECYCLE EVENT] PRE-PERSIST");
        this.createdAt = LocalDateTime.now();
    }

    @PreRemove
    public void preRemove(){
        System.out.println("[LIFECYCLE EVENT] PRE-REMOVE");
    }

    @PreUpdate
    public void preUpdate(){
        System.out.println("[LIFECYCLE EVENT] PRE-UPDATE");
        this.updatedAt = LocalDateTime.now();
    }

    @PostPersist
    public void postPersist(){
        System.out.println("[LIFECYCLE EVENT] POST-PERSIST");
    }

    @PostRemove
    public void postRemove(){
        System.out.println("[LIFECYCLE EVENT] POST-REMOVE");
    }

    @PostUpdate
    public void postUpdate(){
        System.out.println("[LIFECYCLE EVENT] POST-UPDATE");
    }

}
