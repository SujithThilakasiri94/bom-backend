package com.coconut_bom_backend.bom_backend.entities.process1;

import com.coconut_bom_backend.bom_backend.entities.RowItemOrder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProcessOneItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int p1mpId;

    @Column(name = "name", nullable = false,columnDefinition = "VARCHAR(100)")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "calculated_quantity", nullable = false)
    private double calculatedQuantity;

    private String equation;

    @Column(name = "actul_quantity", nullable = false)
    private double actualQuantity;

    @Column(columnDefinition = "VARCHAR(20)")
    private String uom;

    @Column(scale = 2)
    private double unitValue;

    @Column(scale = 2)
    private double totalValue;

    @ManyToOne
    @JoinColumn(name = "raw_item_order_id_fk")
    private RowItemOrder rowItemOrder;
}
