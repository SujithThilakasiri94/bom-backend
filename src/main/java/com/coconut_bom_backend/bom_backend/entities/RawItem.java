package com.coconut_bom_backend.bom_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "row_item")
public class RawItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "row_item_id")
    private int rowItemId;

    @Column(name = "name", nullable = false,columnDefinition = "VARCHAR(100)")
    private String name;

    @Column(name = "description",columnDefinition = "VARCHAR(200)")
    private String description;

    @Column(name = "is_disabled",columnDefinition = "BOOL")
    private boolean isDisabled;

    @OneToMany(mappedBy = "rowItem")
    private List<AddedTo> addedToList;
}
