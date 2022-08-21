package br.edu.ifms.clientcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.clientcrud.model.IdentityDocument;

public interface IdentityDocumentRepository extends JpaRepository<IdentityDocument, Long> {

}
