package dev.gustavorosa.cobranca_cp.service;

import dev.gustavorosa.cobranca_cp.dto.PeriodoDTO;
import dev.gustavorosa.cobranca_cp.model.Pagamento;
import dev.gustavorosa.cobranca_cp.relatorio.EstatisticasPagamentos;
import dev.gustavorosa.cobranca_cp.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RelatorioService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public File relatorioDoClienteHistorico(Long idCliente) {
        List<Pagamento> todosPagamentos = pagamentoRepository.findByContratoClienteId(idCliente);
        EstatisticasPagamentos estatisticas = calcularEstatisticas(todosPagamentos);
    }

    private EstatisticasPagamentos calcularEstatisticas(List<Pagamento> pagamentos) {
        int qtdPagamentos = pagamentos.size();
        Map<YearMonth, Pagamento> pagamentosAtrasados = new HashMap<>();

        for (Pagamento pagamento : pagamentos) {
            if(pagamento.foiPagoComAtraso()){
                pagamentosAtrasados.put(YearMonth.from(pagamento.getDataVencimento()), pagamento);
            }
        }
        int qtdAtrasados = pagamentosAtrasados.size();
    }

    public File relatorioDoClientePorPeriodo(Long idCliente, PeriodoDTO datas) {
        //Captura todos os dados
        List<Pagamento> todosPagamentos = pagamentoRepository.findByContratoClienteId(idCliente);

        //Calcula taxas e quantidades
        calculaPontuaisEInadimplentes(todosPagamentos);

        //Monta pdf

        //retorna pdf
        return new File();
    }
}
