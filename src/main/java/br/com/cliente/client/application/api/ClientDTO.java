package br.com.cliente.client.application.api;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.cliente.client.domain.Client;
import br.com.cliente.client.domain.Sexo;
import lombok.Getter;

@Getter
public class ClientDTO {

	private String name;
	private String email;
	private Sexo sexo;
	private String whatsapp;
	private Date birthDate;

	public ClientDTO(Client client) {
		this.name = client.getName();
		this.email = client.getEmail();
		this.sexo = client.getSexo();
		this.whatsapp = client.getWhatsapp();
		this.birthDate = client.getBirthDate();
	}

	public static List<ClientDTO> listClientDto(List<Client> listClient) {
		return listClient.stream().map(ClientDTO::new).collect(Collectors.toList());
	}

}
