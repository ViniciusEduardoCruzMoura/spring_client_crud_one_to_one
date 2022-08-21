package br.edu.ifms.clientcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.clientcrud.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
