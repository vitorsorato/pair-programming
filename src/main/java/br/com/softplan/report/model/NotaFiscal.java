package br.com.softplan.report.model;

import java.math.BigDecimal;

public class NotaFiscal {

	private final Long numero;
	private final BigDecimal valor;
	
	public NotaFiscal(Long numero, BigDecimal valor) {
		this.numero = numero;
		this.valor = valor;
	}

	public Long getNumero() {
		return numero;
	}

	public BigDecimal getValor() {
		return valor;
	}
	
}
