package br.com.cliente.client.infrastructure;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.com.cliente.client.application.repository.ClientRepository;
import br.com.cliente.client.domain.Client;
import br.com.cliente.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@AllArgsConstructor
@Log4j2
@Component
public class ClientJpaRepository implements ClientRepository {

	private ClientSpringDataJPARepository clientSpringDataJPARepository;

	@Override
	public Page<Client> findALL(Pageable page) {
		log.info("[Starting] findAll - ClientJpaRepository!");
		Page<Client> clientAll = clientSpringDataJPARepository.findAll(page);
		log.info("[Finishing] findAll - ClientJpaRepository!");
		return clientAll;
	}

	@Override
	public Page<Client> findByNameAndAge(String name, Integer age, Pageable page) {
		log.info("[Starting] findByNameAndAge - ClientJpaRepository!");
		Page<Client> findByNameAndAge = clientSpringDataJPARepository.findByNameAndAge(name, age, page);
		log.info("[Finishing] findByNameAndAge - ClientJpaRepository!");
		return findByNameAndAge;
	}

	@Override
	public Client findByIdAndAge(Long id, Integer age) {
		log.info("[Starting] findByIdAndAge - ClientJpaRepository!");
		Client findByIdAndAge = clientSpringDataJPARepository.findByIdAndAge(id, age);
		log.info("[Finishing] findByIdAndAge - ClientJpaRepository!");
		return findByIdAndAge;
	}

	@Override
	public Client findByEmailAndAge(String email, Integer age) {
		log.info("[Starting] findByEmailAndAge - ClientJpaRepository!");
		Client findByEmailAndAge = clientSpringDataJPARepository.findByEmailAndAge(email, age);
		log.info("[Finishing] findByEmailAndAge - ClientJpaRepository!");
		return findByEmailAndAge;
	}

	@Override
	public Client save(Client client) {
		log.info("[Starting] save - ClientJpaRepository!");
		Client saveClient = clientSpringDataJPARepository.save(client);
		log.info("[Finishing] save - ClientJpaRepository!");
		return saveClient;
	}

	@Override
	public Client findById(Long id) throws BusinessException {
		Client findById = clientSpringDataJPARepository.findById(id)
				.orElseThrow(() -> new BusinessException("The client does not exist"));;
		return findById;
	}

	@Override
	public void delete(Long id) {
		log.info("[Starting] delete - ClientJpaRepository!");
		clientSpringDataJPARepository.deleteById(id);
		log.info("[Finishing] delete - ClientJpaRepository!");
		
	}

}
