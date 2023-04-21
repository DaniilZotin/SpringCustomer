package net.proselyte.customerdemo.model;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "groups_table")
public class Group extends BaseEntity{

    @Column(name = "name_group")
    private String nameGroup;

    @Column(name = "community")
    private BigDecimal community;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    List<Developer> developers;

    public Group(){

    }
}
