package com.coconut_bom_backend.bom_backend.entities;

import com.coconut_bom_backend.bom_backend.entities.process1.ProcessOneItems;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Table(name = "row_item_order")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Component
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

    @OneToMany(mappedBy = "rowItemOrder")
    private List<ProcessOneItems> processOneItemsList;

}