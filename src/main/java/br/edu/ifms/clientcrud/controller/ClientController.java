package br.edu.ifms.clientcrud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifms.clientcrud.model.Client;
import br.edu.ifms.clientcrud.repository.ClientRepository;

import java.util.Optional;

@Controller
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping("/new")
	public String newClient(Model model) {
		model.addAttribute("client", new Client());
		return "/create-client";
	}
	
	@PostMapping("/save")
	public String salvarUsuario(@Valid Client client, BindingResult result, 
				RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "/create-client";
		}	
		clientRepository.save(client);
		attributes.addFlashAttribute("mensagem", "Client saved successfully!");
		return "redirect:/client/new";
	}
	
	@RequestMapping("/list")
	public String listarUsuario(Model model) {
		model.addAttribute("clients", clientRepository.findAll());		
		return "/list-client";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Client client = clientRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Id : " + id));
		clientRepository.delete(client);
		return "redirect:/client/list";
	}

	@GetMapping("/update/{id}")
	public String updateClient(@PathVariable("id") long id, Model model) {
		Optional<Client> clientOldDate = clientRepository.findById(id);
		if (!clientOldDate.isPresent()) {
			throw new IllegalArgumentException("Invalid Client : " + id);
		}
		Client client = clientOldDate.get();
		model.addAttribute("client", client);
		return "/update-client";
	}

	@PostMapping("/update/{id}")
	public String updateClient(@PathVariable("id") long id,
								@Valid Client client, BindingResult result) {
		if (result.hasErrors()) {
			client.setIdClient(id);
			return "update-client";
		}
		client.setIdClient(id);
		clientRepository.save(client);
		return "redirect:/client/list";
	}


}
