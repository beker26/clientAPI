package br.com.cliente.client.application.repository;





import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.cliente.client.domain.Client;
import br.com.cliente.exception.BusinessException;

public interface ClientRepository {

	Page<Client> findALL(Pageable page);

	Page<Client> findByNameAndAge(String name, Integer age, Pageable page);

	Client findByIdAndAge(Long id, Integer age);

	Client findByEmailAndAge(String email, Integer age);

	Client save(Client client);

	Client findById(Long id) throws BusinessException;

	void delete(Long id);

}
