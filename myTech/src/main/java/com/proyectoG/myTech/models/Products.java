package com.proyectoG.myTech.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_products")
	@Getter @Setter private Integer idProducts;
    
    @Getter @Setter private String category;
    
    @Column(name = "url_image")
	@Getter @Setter private String urlImage;
    
    @Getter @Setter private Integer price;
    
    @Getter @Setter private String condition;
    
    @Getter @Setter private String color;
    
    @Getter @Setter private String description;
    
    @ManyToOne
    @JoinColumn(name = "id_user", nullable=false)
    @JsonBackReference
    @Getter @Setter private Users user;
}
