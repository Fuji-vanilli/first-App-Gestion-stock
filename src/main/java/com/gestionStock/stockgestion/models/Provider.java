package com.gestionStock.stockgestion.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
//@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Provider extends AbstractEntity{

    private String name;

    @Embedded
    private Adress adress;

    private String email;

    private String tel;

    private String site;

    private String picture;

    @OneToMany(mappedBy = "provider", fetch = FetchType.LAZY)
    private List<CommandProvider> providers;
}
