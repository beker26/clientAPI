package br.com.cliente.client.application.api;

import java.net.URI;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.cliente.client.application.service.ClientService;
import br.com.cliente.client.domain.Client;
import br.com.cliente.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@AllArgsConstructor
public class ClientRestController implements ClientAPI {

	private ClientService clientService;

	@Override
	public Page<ClientDTO> findALL(Pageable page) {
		log.info("[Starting] FindAll - ClientRestController!");
		Page<Client> client = this.clientService.findAll(page);
		log.info("[Finishing] FindAll - ClientRestController!");
		return ClientDTO.convertToPage(client);
	}

	@Override
	public Page<ClientDTO> findByName(String name, Integer age, Pageable page) {
		log.info("[Starting] FindByName - ClientRestController!");
		Page<Client> client = this.clientService.findByName(name, age,page);
		log.info("[Finishing] FindByName - ClientRestController!");
		return ClientDTO.convertToPage(client);
	}

	@Override
	public ResponseEntity<ClientDTO> findById(Long id, Integer age) {
		log.info("[Starting] findById - ClientRestController!");
		Client client = this.clientService.findById(id, age);
		log.info("[Finishing] findById - ClientRestController!");
		return ResponseEntity.ok().body(new ClientDTO(client));
	}

	@Override
	public ResponseEntity<ClientDTO> findByEmail(String email, Integer age) {
		log.info("[Starting] findByEmail - ClientRestController!");
		Client client = this.clientService.findByEmail(email, age);
		log.info("[Finishing] findByEmail - ClientRestController!");
		return ResponseEntity.ok().body(new ClientDTO(client));
	}

	@Override
	public ResponseEntity<ClientDTO> saveNewClient(ClientForm form, UriComponentsBuilder uriBuilder) {
		log.info("[Starting] saveNewClient - ClientRestController!");
		log.info("Form: {}", form);
		Client client = clientService.saveNewClient(form.toClient());
		log.info("[Finishing] saveNewClient - ClientRestController!");
		URI uri = uriBuilder.path("/client/{id}").buildAndExpand(client.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClientDTO(client));
	}

	@Override
	public ResponseEntity<ClientDTO> updateClient(Long id, ClientForm form) throws BusinessException {
		log.info("[Starting] updateClient - ClientRestController!");
		log.info("Form: {}", form);
		Client client = clientService.updateClient(id, form.toClient());
		log.info("[Finishing] updateClient - ClientRestController!");
		return ResponseEntity.ok().body(new ClientDTO(client));
	}

	@Override
	public void deleteClient(Long id) {
		log.info("[Starting] deleteClient - ClientRestController!");
		clientService.deleteClient(id);
		log.info("[Finishing] deleteClient - ClientRestController!");
	}

}
