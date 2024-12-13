package com.proyectoG.myTech.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "order")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
	@Getter @Setter private Integer idOrder;
    
    @Getter @Setter private Integer amount;
    
    @Getter @Setter private Integer subtotal;
    
    @Getter @Setter private Integer total;
    
    @Column(name = "date_creation")
	@Getter @Setter private String dateCreation;
    
    @ManyToOne
    @JoinColumn(name = "id_user", nullable=false)
    @JsonBackReference
    @Getter @Setter private Users user;
    
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Shipments shipment;
}
