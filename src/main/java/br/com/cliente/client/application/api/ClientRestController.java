package br.com.cliente.client.application.api;

import java.net.URI;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.cliente.client.application.service.ClientService;
import br.com.cliente.client.domain.Client;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@AllArgsConstructor
public class ClientRestController implements ClientAPI {

	private ClientService clientService;

	@Override
	public ResponseEntity<List<ClientDTO>> findALL(Pageable paginacao) {
		log.info("[Starting] FindAll - ClientRestController!");
		List<Client> listClient = this.clientService.findAll();
		List<ClientDTO> clientDto = ClientDTO.listClientDto(listClient);
		log.info("[Finishing] FindAll - ClientRestController!");
		return ResponseEntity.ok().body(clientDto);
	}

	@Override
	public ResponseEntity<List<ClientDTO>> findByName(String name, Integer idade, Pageable page) {
		log.info("[Starting] FindByName - ClientRestController!");
		List<Client> listClient = this.clientService.findByName(name, idade);
		List<ClientDTO> clientDto = ClientDTO.listClientDto(listClient);
		log.info("[Finishing] FindByName - ClientRestController!");
		return ResponseEntity.ok().body(clientDto);
	}

	@Override
	public ResponseEntity<ClientDTO> findById(Long id, Integer idade, Pageable page) {
		log.info("[Starting] findById - ClientRestController!");
		Client client = this.clientService.findById(id, idade);
		log.info("[Finishing] findById - ClientRestController!");
		return ResponseEntity.ok().body(new ClientDTO(client));
	}

	@Override
	public ResponseEntity<ClientDTO> findByEmail(String email, Integer idade, Pageable page) {
		log.info("[Starting] findByEmail - ClientRestController!");
		Client client = this.clientService.findByEmail(email, idade);
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
	public ResponseEntity<ClientDTO> updateClient(Long id, ClientForm form) {
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
