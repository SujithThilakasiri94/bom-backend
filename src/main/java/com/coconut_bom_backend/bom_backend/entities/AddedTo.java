package com.coconut_bom_backend.bom_backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "added_to")
public class AddedTo {

    @Id
    @Column(name = "added_to_id")
    private int addedToId;

    @Column(name = "quantity",scale = 2,nullable = false)
    private double quantity;

    @Column(name = "unit_price",scale = 2,nullable = false)
    private double unit_price;

}
