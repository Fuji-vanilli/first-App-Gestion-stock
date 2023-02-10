package com.gestionStock.stockgestion.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Builder
public class Category extends AbstractEntity{
    private String code;
    private String designation;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Article> articles;

}
