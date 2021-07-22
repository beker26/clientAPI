package br.com.cliente.client.application.api;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import br.com.cliente.client.domain.Client;
import br.com.cliente.client.domain.Sexo;

public class ClientForm {
	
	@Size(min = 3, message = "Number of characters does not match the minimum limit of 3 characters!")
	@Size(max = 260, message = "Number of characters exceeds the limit of 260 characters!")
	@NotNull(message = "name cannot be null")
	@NotEmpty(message = "Required field")
	private String name;

	@NotNull(message = "whatsapp cannot be null!")
	@NotEmpty(message = "Required field")
	@Pattern(regexp = "^\\(?(?:[14689][1-9]|2[12478]|3[1234578]|5[1345]|7[134579])\\)? ?(?:[2-8]|9[1-9])[0-9]{3}\\-?[0-9]{4}$", message = "“WhatsApp number is not in a valid format!")
	private String whatsapp;

	@NotNull(message = "email cannot be null")
	@NotEmpty(message = "Required field")
	@Email(message = "Invalid format email")
	private String email;

	@NotNull(message = "sex cannot be null")
	@NotEmpty(message = "Required field")
	private Sexo sexo;

	public Client toClient() {
		return Client.builder()
				.name(name)
				.email(email)
				.sexo(sexo)
				.whatsapp(whatsapp)
				.build();
			}

}
