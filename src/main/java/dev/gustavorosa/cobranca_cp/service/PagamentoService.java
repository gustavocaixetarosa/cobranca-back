package dev.gustavorosa.cobranca_cp.service;

import dev.gustavorosa.cobranca_cp.model.Contrato;
import dev.gustavorosa.cobranca_cp.model.Pagamento;
import dev.gustavorosa.cobranca_cp.model.SituacaoPagamento;
import dev.gustavorosa.cobranca_cp.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.util.ArrayList;
import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public List<Pagamento> gerarPagamentosAutomaticos(Contrato novoContrato){
        List<Pagamento> novosPagamentos = new ArrayList<>();
        List<LocalDate> todasDatasVencimento = gerarDatasVencimento(novoContrato);
        int numeroPagamento = 1;
        for (LocalDate data: todasDatasVencimento){
            novosPagamentos.add(gerarPagamento(novoContrato, data, numeroPagamento));
            numeroPagamento++;
        }
        System.out.println(novosPagamentos);
        return novosPagamentos;
    }

    private Pagamento gerarPagamento(Contrato novoContrato, LocalDate data, int numero) {
        return new Pagamento(null, novoContrato, novoContrato.getValorMensal(), data, null, SituacaoPagamento.EM_ABERTO, null, numero);
    }

    private List<LocalDate> gerarDatasVencimento(Contrato novoContrato){
        Month primeiroMes = (novoContrato.getDiaVencimento() > LocalDate.now().getDayOfMonth())
                ? LocalDate.now().getMonth() : LocalDate.now().getMonth().plus(1);
        List<LocalDate> todasDatas = new ArrayList<>();
        int anoAtual = LocalDate.now().getYear();
        for(int i = 0; i < novoContrato.getParcelas(); i++){
            LocalDate novaData = LocalDate.of(anoAtual, primeiroMes, novoContrato.getDiaVencimento()).plusMonths(i);
            todasDatas.add(novaData);
        }
        return todasDatas;
    }
}
