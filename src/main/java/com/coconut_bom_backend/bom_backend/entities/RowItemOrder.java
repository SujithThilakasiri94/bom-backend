package com.coconut_bom_backend.bom_backend.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "row_item_order")
public class RowItemOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "row_item_oder_id")
    private int rowItemOderId;

    @Column(name = "date", nullable = false, columnDefinition = "DATE")
    private LocalDate date;

    @Column(nullable = false)
    private LocalTime time;

    @Column(name = "total_price", scale = 2, nullable = false)
    private double totalPrice;

    @OneToMany(mappedBy = "rowItemOrder")
    private List<AddedTo> addedToList;
}