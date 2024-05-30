package com.servico.backservico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servico.backservico.entity.Servico;
import com.servico.backservico.service.ServicoService;

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
	
	@PostMapping("/{id}")
	public ResponseEntity<Void> cancelar(@PathVariable("id") Long id){
		
		servicoServ.cancelarServico(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/")
	public Servico alterar(@RequestBody Servico serv) {
		
		return servicoServ.alterar(serv);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
		
		servicoServ.excluir(id);
		return ResponseEntity.ok().build();
	}
	
}
