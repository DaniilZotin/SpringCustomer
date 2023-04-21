package net.proselyte.customerdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "developers")
public class Developer extends BaseEntity{

    private String role;
    private Integer experience;

    public Developer(){

    }

    @ManyToOne
    @JoinColumn(name = "developer_id")
    private Group group;
}
