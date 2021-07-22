package br.com.cliente.client.application.api;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/v1/client")
public interface ClientAPI {
	
	@GetMapping("/findAll")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<ClientDTO>> findALL(@PageableDefault(sort = "name", direction = Direction.DESC, page = 0, size = 10) Pageable page);
	
	@GetMapping("/findByName")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<ClientDTO>> findByName(@RequestParam String name,@RequestParam Integer idade, @PageableDefault(sort = "name", direction = Direction.DESC, page = 0, size = 10) Pageable page);
	
	@GetMapping("/findByid")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<ClientDTO> findById(@RequestParam Long id,@RequestParam Integer idade,Pageable page);
	
	@GetMapping("/findByEmail")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<ClientDTO> findByEmail(@RequestParam String email, @RequestParam Integer idade,@PageableDefault(sort = "email", direction = Direction.DESC, page = 0, size = 10) Pageable page);
	
	@PostMapping("/{id}/registerClient")
	@Transactional
	public ResponseEntity<ClientDTO> saveNewClient(@Validated @RequestBody ClientForm form, UriComponentsBuilder uriBuilder);
	
	@DeleteMapping("/{id}/deleteClient")
	@Transactional
	public ResponseEntity<List<ClientDTO>> deleteClient(@PathVariable Long id);
	
	@PutMapping("/{id}/editClient")
	@Transactional
	public ResponseEntity<List<ClientDTO>> updateClient(@PathVariable Long id, @Validated @RequestBody ClientForm form);
	
	

}
