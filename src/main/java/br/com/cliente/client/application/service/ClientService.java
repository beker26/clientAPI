package br.com.cliente.client.application.service;

import java.util.List;

import br.com.cliente.client.domain.Client;

public interface ClientService {

	List<Client> findAll();

	List<Client> findByName(String name, Integer idade);

	Client findById(Long id, Integer idade);

	Client findByEmail(String email, Integer idade);

	Client saveNewClient(Client client);

	Client updateClient(Long id, Client client);

	void deleteClient(Long id);

}
