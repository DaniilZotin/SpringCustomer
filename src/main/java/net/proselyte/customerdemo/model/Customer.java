package net.proselyte.customerdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Simple JavaBean domain object that represents Customer
 */

@Entity
@Data
@Table(name = "customers")
public class Customer extends BaseEntity{

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "address")
    private String address;
    @Column(name = "budget")
    private BigDecimal budget;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
//    @JsonIgnore
    private List<Order> orders;
}

