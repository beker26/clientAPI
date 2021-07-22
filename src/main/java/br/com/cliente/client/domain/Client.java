package br.com.cliente.client.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;

@Entity
@Builder
@Getter
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;
	
	private String email;

	@Enumerated(EnumType.STRING)
	private Sexo sexo;

	@Column(name = "BIRTH_DATE")
	private Date birthDate;
	
	private String whatsapp;

}
