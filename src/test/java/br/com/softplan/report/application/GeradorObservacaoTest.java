package br.com.softplan.report.application;

import br.com.softplan.report.model.NotaFiscal;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;

public class GeradorObservacaoTest {

    private GeradorObservacao geradorObservacao;

    @Before
    public void setUp() {
        geradorObservacao = new GeradorObservacao();
    }

    private NotaFiscal criarNotaFiscal(Long numero) {
        return new NotaFiscal(numero, BigDecimal.ZERO);
    }

    @Test
    public void deveGerarObservacaoSemNota() {
        List<NotaFiscal> notasFiscais = new ArrayList<>();

        String observacao = geradorObservacao.geraObservacao(notasFiscais);

        assertEquals("", observacao);
    }

    @Test
    public void deveGerarObservacaoComUmaNota() {
        List<NotaFiscal> notasFiscais = singletonList(criarNotaFiscal(1L));

        String observacao = geradorObservacao.geraObservacao(notasFiscais);

        assertEquals("Fatura da nota fiscal de simples remessa: 1.", observacao);
    }

    @Test
    public void deveGerarObservacaoComDuasNotas() {
        List<NotaFiscal> notasFiscais = asList(criarNotaFiscal(1L), criarNotaFiscal(3L));

        String observacao = geradorObservacao.geraObservacao(notasFiscais);

        assertEquals("Fatura das notas fiscais de simples remessa: 1 e 3.", observacao);
    }

    @Test
    public void deveGerarObservacaoComDiversasNotas() {
        List<NotaFiscal> notasFiscais = asList(criarNotaFiscal(1L), criarNotaFiscal(2L), criarNotaFiscal(3L), criarNotaFiscal(4L), criarNotaFiscal(5L));
        String observacao = geradorObservacao.geraObservacao(notasFiscais);

        assertEquals("Fatura das notas fiscais de simples remessa: 1, 2, 3, 4 e 5.", observacao);
    }
}
