package dev.gustavorosa.cobranca_cp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ClienteDTO(
        @NotBlank(message = "Nome do cliente nao pode estar vazio.") String nome,
        String endereco,
        String telefone,
        LocalDate dataContrato,
        @NotBlank(message = "Cliente deve ter cpf ou cnpj") String registro,
        String banco
) {
}
