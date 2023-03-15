package com.gestionStock.stockgestion.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.Instant;

@Data
@MappedSuperclass
public class AbstractEntity implements Serializable {
    @Id
    private String id;
    @CreatedDate
    @JsonIgnore
    private Instant dateCreation;
    @LastModifiedDate
    @JsonIgnore
    private Instant lastModifiedDate;
}
