package br.com.cliente.client.application.service;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.cliente.client.application.repository.ClientRepository;
import br.com.cliente.client.domain.Client;
import br.com.cliente.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@AllArgsConstructor
public class ClientSpringDataJPAService implements ClientService {

	private ClientRepository clientRepository;

	@Override
	public Page<Client> findAll(Pageable page) {
		log.info("[Starting] findAll - ClientSpringDataJPAService!");
		Page<Client> clientALL = clientRepository.findALL(page);
		log.info("[Finishing] findAll - ClientSpringDataJPAService!");
         return clientALL;
	}

	@Override
	public Page<Client> findByName(String name, Integer age, Pageable page) {
		log.info("[Starting] findByName - ClientSpringDataJPAService!");
		Page<Client> clientByNameAndAge = clientRepository.findByNameAndAge(name,age,page);
		log.info("[Finishing] findByName - ClientSpringDataJPAService!");
		return clientByNameAndAge;
	}

	@Override
	public Client findById(Long id, Integer age) {
		log.info("[Starting] findById - ClientSpringDataJPAService!");
		Client findByIdAndAge = clientRepository.findByIdAndAge(id,age);
		log.info("[Finishing] findById  - ClientSpringDataJPAService!");
		return findByIdAndAge;
	}

	@Override
	public Client findByEmail(String email, Integer age) {
		log.info("[Starting] findByEmail - ClientSpringDataJPAService!");
		Client clientByEmailAndAge = clientRepository.findByEmailAndAge(email,age);
		log.info("[Finishing] findByEmail - ClientSpringDataJPAService!");
		return clientByEmailAndAge;
	}

	@Override
	public Client saveNewClient(Client client) {
		log.info("[Starting] saveNewClient - ClientSpringDataJPAService!");
		Client saveClient = saveClient(client);
		log.info("[Finishing] saveNewClient - ClientSpringDataJPAService!");
		return saveClient ;
	}

	private Client saveClient(Client client) {
		return clientRepository.save(client);
		
	}

	@Override
	public Client updateClient(Long id, Client client) throws BusinessException {
		log.info("[Starting] updateClient - ClientSpringDataJPAService!");
		Client clientById = clientRepository.findById(id);
		clientById.update(client);
		Client saveClient = saveClient(clientById);
		log.info("[Finishing] updateClient - ClientSpringDataJPAService!");
		return saveClient;
	}

	@Override
	public void deleteClient(Long id) {
		log.info("[Starting] deleteClient - ClientSpringDataJPAService!");
		clientRepository.delete(id);
		log.info("[Finishing] deleteClient - ClientSpringDataJPAService!");
    }

}
