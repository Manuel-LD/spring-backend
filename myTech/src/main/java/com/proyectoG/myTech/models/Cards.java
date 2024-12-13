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
@Table(name = "card")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_card")
    @Getter @Setter private Integer idCard;
    
    @Column(name = "name_card")
    @Getter @Setter private String nameCard;
    
    @Column(name = "number_card")
    @Getter @Setter private Integer numberCard;
    
    @Column
	@Getter @Setter private Integer cvv;
    
    @Column(name = "expiration_date")
    @Getter @Setter private String expirationDate;
    
    @OneToOne(mappedBy = "card", cascade = CascadeType.ALL, orphanRemoval = true)
    private Users user;
}
