package br.com.cliente.client.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.cliente.client.application.repository.ClientRepository;
import br.com.cliente.client.domain.Client;
import br.com.cliente.client.domain.Gender;

class ClientSpringDataJPAServiceTest {

	private ClientSpringDataJPAService clientSpringDataJPAService; 
	
	@Mock
	private ClientRepository clientRepository;
	
	private Client client;
	
	private Gender gender;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.clientSpringDataJPAService = new ClientSpringDataJPAService(clientRepository);
		this.client = Client.builder()
						.name("RODRIGO BEKER")
						.age(27)
						.email("beker_la@hotmail.com")
						.whatsapp("(73) 99971-3718")
						.gender(gender.M)
						.build();
	}

	@Test
	void deveSalvarERetornarUmCLientCasoOClientSejaValido() {
		Mockito.when(clientRepository.save(client)).thenReturn(client);
		Client clientRetornado = clientSpringDataJPAService.saveNewClient(client);
		
		assertEquals(clientRetornado, client);
		Mockito.verify(clientRepository).save(client);
	}
	

	

}
