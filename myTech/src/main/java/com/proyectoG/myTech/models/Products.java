package com.proyectoG.myTech.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	@JsonProperty("id_products")
	@Getter @Setter private Integer idProducts;
    
    @Column(name = "category")
	@JsonProperty("category")
    @Getter @Setter private String category;
    
    @Column(name = "url_image")
    @JsonProperty("url_image")
	@Getter @Setter private String urlImage;
    
    @Column(name = "price")
	@JsonProperty("price")
    @Getter @Setter private Integer price;
    
    @Column(name = "condition")
	@JsonProperty("condition")
    @Getter @Setter private String condition;
    
    @Column(name = "color")
	@JsonProperty("color")
    @Getter @Setter private String color;
    
    @Column(name = "description")
	@JsonProperty("description")
    @Getter @Setter private String description;
    
    @ManyToOne
    @JoinColumn(name = "user_id_user", nullable=false)
    @JsonBackReference
    @Getter @Setter private Users user;
}
