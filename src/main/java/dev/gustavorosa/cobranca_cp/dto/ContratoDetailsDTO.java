package dev.gustavorosa.cobranca_cp.dto;

import dev.gustavorosa.cobranca_cp.model.Cliente;
import dev.gustavorosa.cobranca_cp.model.Contrato;
import dev.gustavorosa.cobranca_cp.model.Pagamento;

import java.time.LocalDate;
import java.util.List;

public record ContratoDetailsDTO(
        Long contrato_id,
        Long cliente_id,
        Integer duracao_em_meses,
        String cpf_contratante,
        String nome_contratante,
        LocalDate data,
        Double valor_contrato
) {

    public ContratoDetailsDTO(Contrato contrato){
        this(
                contrato.getId(),
                contrato.getCliente().getId(),
                contrato.getDuracaoEmMeses(),
                contrato.getCpfContratante(),
                contrato.getNomeContratante(),
                contrato.getData(),
                contrato.getValorContrato());
    }
}
