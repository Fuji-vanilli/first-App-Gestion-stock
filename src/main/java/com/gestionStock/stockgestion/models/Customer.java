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
public class Customer extends AbstractEntity{

    private String firstname;

    private String lastname;

    @Embedded
    private Adress adress;

    private String picture;

    private String email;

    private String tel;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<CommandCustomer> commandCustomers;

}
