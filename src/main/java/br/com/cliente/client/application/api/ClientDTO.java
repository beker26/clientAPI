package br.com.cliente.client.application.api;

import org.springframework.data.domain.Page;

import br.com.cliente.client.domain.Client;
import br.com.cliente.client.domain.Gender;
import lombok.Getter;

@Getter
public class ClientDTO {

	private String name;
	private String email;
	private Gender gender;
	private String whatsapp;
	private Integer age;

	public ClientDTO(Client client) {
		this.name = client.getName();
		this.email = client.getEmail();
		this.gender = client.getGender();
		this.whatsapp = client.getWhatsapp();
		this.age = client.getAge();
	}

	public static Page<ClientDTO> convertToPage(Page<Client> client) {
		return client.map(ClientDTO::new);
	}

}
