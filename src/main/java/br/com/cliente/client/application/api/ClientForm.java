package br.com.cliente.client.application.api;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.cliente.client.domain.Client;
import br.com.cliente.client.domain.Gender;
import lombok.Getter;

@Getter
public class ClientForm {
	
	@Size(min = 3, message = "Number of characters does not match the minimum limit of 3 characters!")
	@Size(max = 260, message = "Number of characters exceeds the limit of 260 characters!")
	@NotNull(message = "name cannot be null")
	@NotEmpty(message = "Required field")
	private String name;

	@NotNull(message = "whatsapp cannot be null!")
	@NotEmpty(message = "Required field")
	@Pattern(regexp = "^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$", message = "“WhatsApp number is not in a valid format!")
	private String whatsapp;

	@NotNull(message = "email cannot be null")
	@NotEmpty(message = "Required field")
	@Email(message = "Invalid format email")
	private String email;

	@NotNull(message = "gender cannot be null")
	private Gender gender;
	
	@NotNull(message = "idade cannot be null")
	private Integer age;

	public Client toClient() {
		return Client.builder()
				.name(name)
				.email(email)
				.whatsapp(whatsapp)
				.gender(gender)
				.age(age)
				.build();
			}

}
