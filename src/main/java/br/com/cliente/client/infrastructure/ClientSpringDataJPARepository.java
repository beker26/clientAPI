package br.com.cliente.client.infrastructure;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.cliente.client.domain.Client;

@Repository
public interface ClientSpringDataJPARepository extends JpaRepository<Client, Long> {

	@Query(name = "Client.findByNameAndAge", nativeQuery = true)
	Page<Client> findByNameAndAge(@Param("name") String name, @Param("age") Integer age, Pageable page);

	@Query(name = "Client.findByIdAndAge", nativeQuery = true)
	Client findByIdAndAge(@Param("id") Long id, @Param("age") Integer age);

	@Query(name = "Client.findByEmailAndAge", nativeQuery = true)
	Client findByEmailAndAge(@Param("email") String email, @Param("age") Integer age);

}
