package net.proselyte.customerdemo.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "groups_table")
public class Group extends BaseEntity{

    @Column(name = "name_group")
    private String nameGroup;

    @Column(name = "community")
    private BigDecimal community;

    public Group(){

    }
}
