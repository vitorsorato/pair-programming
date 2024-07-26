package br.com.softplan.report.application;

import br.com.softplan.report.model.NotaFiscal;

import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;

public class GeradorObservacao {

	private static final String NENHUMA_NOTA = "";
	private static final String UMA_NOTA = "Fatura da nota fiscal de simples remessa: ";
	private static final String MULTIPLAS_NOTAS = "Fatura das notas fiscais de simples remessa: ";
		
	public String geraObservacao(List<NotaFiscal> notasFiscais)
	{

		if (notasFiscais.isEmpty()){
			return NENHUMA_NOTA;
		}
        return (notasFiscais.size() == 1 ? UMA_NOTA : MULTIPLAS_NOTAS) + formatarNumeros(notasFiscais) + ".";
	}

	private String formatarNumeros(List<NotaFiscal> notasFiscais) {
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < notasFiscais.size(); i++) {
			if (i > 0) {
				if (i == notasFiscais.size() - 1) {
					builder.append(" e ");
				} else {
					builder.append(", ");
				}
			}
			builder.append(notasFiscais.get(i).getNumero());
		}

		return builder.toString();
	}
}