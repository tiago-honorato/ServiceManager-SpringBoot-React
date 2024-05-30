package com.servico.backservico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servico.backservico.entity.Servico;
import com.servico.backservico.service.ServicoService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/servico")
public class ServicoController {

	@Autowired
	private ServicoService servicoServ;
	
	@GetMapping("/")
	public List<Servico> buscarTodos(){
		
		return servicoServ.buscarTodos();
		
	}
	
	@GetMapping("/pagamentoPendente")
	public List<Servico> buscarServicosPagamentoPendente(){
		
		return servicoServ.buscarServicosPagamentoPendente();
		
	}
	
	@GetMapping("/cancelados")
	public List<Servico> buscarServicosCancelados(){
		
		return servicoServ.buscarServicosCancelados();
				
	}
	
	@PostMapping("/")
	public Servico inserir(@RequestBody Servico serv) {
		
		return servicoServ.inserir(serv);
	}
	
	@PutMapping("/")
	public Servico alterar(@RequestBody Servico serv) {
		
		return servicoServ.alterar(serv);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathParam("id") Long id) {
		
		servicoServ.excluir(id);
		return ResponseEntity.ok().build();
	}
	
}
