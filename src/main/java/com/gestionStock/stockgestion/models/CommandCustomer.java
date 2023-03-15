package com.gestionStock.stockgestion.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Entity
//@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommandCustomer extends AbstractEntity{

    private String code;

    private Instant dateCommand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCustomer", referencedColumnName = "id")
    private Customer customer;

    @OneToMany(mappedBy = "commandCustomer", fetch = FetchType.LAZY)
    private List<LineCommandCustomer> lineCommandCustomers;


}
