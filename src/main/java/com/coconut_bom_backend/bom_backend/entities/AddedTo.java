package com.coconut_bom_backend.bom_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "added_to")
@Entity
@Component
public class AddedTo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "added_to_id")
    private int addedToId;

    @Column(name = "quantity",scale = 2,nullable = false)
    private double qty;

    @Column(name = "unit_price",scale = 2,nullable = false)
    private double unitPrice;

    @ManyToOne
    @JoinColumn(name = "raw_item_id_fk")
    private RowItem rowItem;//row item id

    @ManyToOne
    @JoinColumn(name = "raw_item_order_id_fk")
    private RowItemOrder rowItemOrder;//oder id

}
