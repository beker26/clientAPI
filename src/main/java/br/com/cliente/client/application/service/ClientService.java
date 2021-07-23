package br.com.cliente.client.application.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.cliente.client.domain.Client;
import br.com.cliente.exception.BusinessException;

public interface ClientService {

	Page<Client> findAll(Pageable page);

	Page<Client> findByName(String name, Integer age,Pageable page);

	Client findById(Long id, Integer age);

	Client findByEmail(String email, Integer age);

	Client saveNewClient(Client client);

	Client updateClient(Long id, Client client) throws BusinessException;

	void deleteClient(Long id);

}
