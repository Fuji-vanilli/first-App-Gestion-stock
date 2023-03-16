package com.gestionStock.stockgestion.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {
    @Id
    private String id;

    @CreatedDate
    @Column(insertable = false, updatable = false, name = "createdDate", nullable = false)
    @JsonIgnore
    private Instant dateCreated;

    @LastModifiedDate
    @Column(insertable = false, updatable = false, name = "lastModifiedDate")
    @JsonIgnore
    private Instant lastModifiedDate;

}
