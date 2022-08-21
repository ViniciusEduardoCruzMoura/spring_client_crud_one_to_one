package br.edu.ifms.clientcrud.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifms.clientcrud.model.Client;
import br.edu.ifms.clientcrud.model.IdentityDocument;
import br.edu.ifms.clientcrud.repository.ClientRepository;
import br.edu.ifms.clientcrud.repository.IdentityDocumentRepository;

@Controller
@RequestMapping("/identitydocument")
public class IdentityDocumentController {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired	
	private IdentityDocumentRepository identityDocumentRepository;
	
	@PostMapping("/save/{id}")
	public String saveIdentityDocument(@Valid IdentityDocument identityDocument, 				
			BindingResult result, 
			Model model,
			@PathVariable("id") long idClient) {
		Optional<Client> clientBanco = clientRepository.findById(idClient);
		Client client = clientBanco.get();
		if (result.hasErrors()) {
			identityDocument.setClient(client);
			return "/create-client-identitydocument";
		}
		identityDocument.setClient(client);
		identityDocumentRepository.save(identityDocument);
		return "redirect:/client/update/"+identityDocument.getClient().getIdClient();
	}
	
	@GetMapping("/createOrUpdate/{id}")
	public String createOrUpdateIdentityDocument(@PathVariable("id") long idClient, Model model) {		
		Optional<Client> clientVelho = clientRepository.findById(idClient);
		if (!clientVelho.isPresent()) {
            throw new IllegalArgumentException("Cliente invalido:" + idClient);
        } 
		Client client = clientVelho.get();
		IdentityDocument identitydocument = null;
		String url = "";
		if (client.getIdentityDocument() == null) {
			identitydocument = new IdentityDocument();
			identitydocument.setClient(client);
			url = "/create-client-identitydocument";
		} else {
			identitydocument = client.getIdentityDocument();
			//url = "/update-client-identitydocument";
			url = "redirect:/client/list";
		}		
		model.addAttribute("identityDocument", identitydocument);
	    return url;
	}

}
