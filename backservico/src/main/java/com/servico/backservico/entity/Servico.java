package com.servico.backservico.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "servico")
public class Servico {
	
	public Servico() {}
	
	public Servico(String nomeCliente, Date dataInicio, Date dataTermino, String descricaoServico,
			Double valorServico, Double valorPago, Date dataPagamento, String status) {
		super();
		this.nomeCliente = nomeCliente;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.descricaoServico = descricaoServico;
		this.valorServico = valorServico;
		this.valorPago = valorPago;
		this.dataPagamento = dataPagamento;
		this.status = status;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nomeCliente;
	@Temporal(TemporalType.DATE)
	private Date dataInicio = new Date();
	@Temporal(TemporalType.DATE)
	private Date dataTermino;
	private String descricaoServico;
	private Double valorServico;
	private Double valorPago;
	private Date dataPagamento;
	private String status;//pendente, realizado ou cancelado
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}
	public String getDescricaoServico() {
		return descricaoServico;
	}
	public void setDescricaoServico(String descricaoServico) {
		this.descricaoServico = descricaoServico;
	}
	public Double getValorServico() {
		return valorServico;
	}
	public void setValorServico(Double valorServico) {
		this.valorServico = valorServico;
	}
	public Double getValorPago() {
		return valorPago;
	}
	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}
	public Date getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}