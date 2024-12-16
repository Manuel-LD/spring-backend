package com.proyectoG.myTech.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "card")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_card")
    @JsonProperty("id_card")
    @Getter @Setter private Integer idCard;
    
    @Column(name = "name_card")
    @JsonProperty("name_card")
    @Getter @Setter private String nameCard;
    
    @Column(name = "number_card")
    @JsonProperty("number_card")
    @Getter @Setter private Long numberCard;
    
    @Column(name = "cvv")
	@JsonProperty("cvv")
	@Getter @Setter private Integer cvv;
    
    @Column(name = "expirationDate")
	@JsonProperty("expirationDate")
    @Getter @Setter private String expirationDate;
    
    @OneToOne
    @JoinColumn(name = "user_id_user", nullable = false)
    @JsonManagedReference
    private Users user;
}
