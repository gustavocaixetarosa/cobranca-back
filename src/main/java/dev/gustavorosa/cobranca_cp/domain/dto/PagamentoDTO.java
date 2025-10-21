package dev.gustavorosa.cobranca_cp.domain.dto;

import dev.gustavorosa.cobranca_cp.domain.model.Pagamento;

public record PagamentoDTO(
        Long pagamento_id,
        Long contrato_id,
        Double valor,
        String data_pagamento,
        String data_vencimento,
        String status,
        String observacao,
        Integer numero_parcela
) {

    public PagamentoDTO(Pagamento pagamento){
        this(
                pagamento.getId(),
                pagamento.getContrato().getId(),
                pagamento.getValor(),
                pagamento.getDataPagamento(),
                pagamento.getDataVencimento().toString(),
                pagamento.getStatus().toString(),
                pagamento.getObservacao(),
                pagamento.getNumeroParcela()
        );
    }
}
