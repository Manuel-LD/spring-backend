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
@Table(name = "message")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Messages {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_message")
	@JsonProperty("id_message")
	@Getter @Setter private Integer idMessage;
	
	@Column(name = "comment")
	@JsonProperty("comment")
	@Getter @Setter private String comment;
    
    @ManyToOne
    @JoinColumn(name = "id_user", nullable=false)
    @JsonBackReference
    @Getter @Setter private Users user;

}
