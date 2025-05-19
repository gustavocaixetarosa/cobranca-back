package dev.gustavorosa.cobranca_cp.dto;

import dev.gustavorosa.cobranca_cp.model.Contrato;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ContratoDTO(
        @NotNull(message = "Id do cliente e obrigatorio.") Long clienteId,
        @NotBlank(message = "Nome do mensalista e obrigatorio.") String nomeMensalista,
        String registroMensalista,
        String telefoneMensalista,
        @NotNull(message = "Duracao do contrato e indispensavel.") Integer duracaoEmMeses,
        @NotNull(message = "Dia do vencimento mensal e obrigatorio.") Integer diaVencimento,
        @NotNull(message = "O valor mensal e obrigatorio.")  BigDecimal valorMensal
) {
    public ContratoDTO(Contrato novoContrato) {
        this(
                novoContrato.getCliente().getId(),
                novoContrato.getNomeMensalista(),
                novoContrato.getRegistroMensalista(),
                novoContrato.getTelefoneMensalista(),
                novoContrato.getParcelas(),
                novoContrato.getDiaVencimento(),
                novoContrato.getValorMensal()
        );
    }
}
