package com.proyectoG.myTech.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "shipment")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Shipments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_shipment")
	@Getter @Setter private Integer idShipment;
    
    @Getter @Setter private String address;
    
    @Column(name = "tracking_number")
	@Getter @Setter private String trackingNumber;
    
    @Getter @Setter private String status;
    
    @Column(name = "shipping_date")
	@Getter @Setter private String shippingDate;
    
    @Column(name = "estimated_delivery_date")
	@Getter @Setter private String estimatedDeliveryDate;
    
    @OneToOne(mappedBy = "shipment", cascade = CascadeType.ALL, orphanRemoval = true)
    private Orders order;
}
