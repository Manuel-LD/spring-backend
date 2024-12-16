package com.proyectoG.myTech.models;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Users {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	@JsonProperty("id_user")
	@Getter @Setter private Integer idUser;
	
	@Column(name = "first_name")
	@JsonProperty("first_name")
	@Getter @Setter private String firstName;
    
	@Column(name = "last_name")
	@JsonProperty("last_name")
    @Getter @Setter private String lastName;
    
	@Column(name = "address")
	@JsonProperty("address")
    @Getter @Setter private String address;
    
	@Column(name = "email")
	@JsonProperty("email")
    @Getter @Setter private String email;
    
    @Column(name = "phone_number")
    @JsonProperty("phone_number")
	@Getter @Setter private String phoneNumber;
    
    @Column(name = "rol")
	@JsonProperty("rol")
    @Getter @Setter private String rol;
    
    @OneToMany(mappedBy ="user", fetch = FetchType.LAZY)
	@JsonManagedReference
	@Getter @Setter private Set<Messages> messages = new HashSet<>();
    
    @OneToMany(mappedBy ="user", fetch = FetchType.LAZY)
	@JsonManagedReference
	@Getter @Setter private Set<Orders> orders = new HashSet<>();
    
    @OneToMany(mappedBy ="user", fetch = FetchType.LAZY)
	@JsonManagedReference
	@Getter @Setter private Set<Products> products = new HashSet<>();
    
    @OneToOne(mappedBy = "user")
    @JsonBackReference
    private Cards card;
}
