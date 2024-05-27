package com.servico.backservico.service;
import com.servico.backservico.entity.Servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servico.backservico.repository.ServicoRepository;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository repository;
	
	public List<Servico> buscarTodos(){
		
		return repository.findAll();
		
	}
	
	public List<Servico> buscarServicosPagamentoPendente(){
		
		return repository.buscarServicoPagamentoPendente();
		
	}
	
	public List<Servico> buscarServicosCancelados(){
		
		return repository.buscarServicosCancelados();
				
	}
	
	
	public Servico inserir(Servico serv) {
		
		if (serv.getValorPago()== null || serv.getValorPago() == 0 || serv.getDataPagamento() == null) {
		
			serv.setStatus("pendente");
			
		}else {
			
			serv.setStatus("realizado");
			
		}
		
		return repository.saveAndFlush(serv);
		
	}
	
	public Servico alterar(Servico serv) {
		
		if (serv.getValorPago()!=null && serv.getValorPago() > 0 && serv.getDataPagamento() != null) {
			
			serv.setStatus("realizado");
			
		}
		
		return repository.saveAndFlush(serv);
		
	}
	
	public void excluir(Long id) {
		
		Servico servico = repository.findById(id).get();
		repository.delete(servico);
		
		
	}
	
}
