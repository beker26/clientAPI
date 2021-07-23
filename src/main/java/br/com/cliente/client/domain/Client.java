package br.com.cliente.client.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@NoArgsConstructor 
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "CLIENT")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Column(unique=true)
	private String email;

	@Column()
	@Enumerated(EnumType.STRING)
	private Gender gender;

	private Integer age;

	@Column(unique=true)
	private String whatsapp;

	public void update(Client client) {
		name = client.getName();
		email = client.getEmail();
		gender = client.getGender();
		age = client.getAge();
		whatsapp = client.getWhatsapp();
		
	}

}
