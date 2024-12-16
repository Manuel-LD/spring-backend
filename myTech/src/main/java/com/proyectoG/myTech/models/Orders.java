package com.proyectoG.myTech.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

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
@Table(name = "customer_order")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    @JsonProperty("id_order")
	@Getter @Setter private Integer idOrder;
    
    @Column(name = "amount")
	@JsonProperty("amount")
    @Getter @Setter private Integer amount;
    
    @Column(name = "subtotal")
	@JsonProperty("subtotal")
    @Getter @Setter private Integer subtotal;
    
    @Column(name = "total")
	@JsonProperty("total")
    @Getter @Setter private Integer total;
    
    @Column(name = "date_creation")
    @JsonProperty("date_creation")
	@Getter @Setter private String dateCreation;
    
    @ManyToOne
    @JoinColumn(name = "user_id_user", nullable=false)
    @JsonBackReference
    @Getter @Setter private Users user;
    
    /*@OneToOne
    @JoinColumn(name = "shipment_id_shipment", nullable = false)
    @JsonManagedReference
    private Shipments shipment;*/
}
