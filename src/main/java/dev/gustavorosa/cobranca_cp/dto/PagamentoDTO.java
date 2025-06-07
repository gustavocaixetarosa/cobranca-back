package dev.gustavorosa.cobranca_cp.dto;

import dev.gustavorosa.cobranca_cp.model.Pagamento;

public record PagamentoDTO(
        Long pagamentoId,
        Long contratoId,
        Double valor,
        String dataPagamento,
        String dataVencimento,
        String status
) {

    public PagamentoDTO(Pagamento pagamento){
        this(
                pagamento.getId(),
                pagamento.getContrato().getId(),
                pagamento.getValor(),
                pagamento.getDataPagamento().toString(),
                pagamento.getDataVencimento().toString(),
                pagamento.getStatus().toString()
        );
    }
}
