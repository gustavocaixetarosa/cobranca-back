package dev.gustavorosa.cobranca_cp.dto;

import dev.gustavorosa.cobranca_cp.model.Cliente;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record ClienteDTO(
        @NotBlank(message = "Nome do cliente nao pode estar vazio.") String nome,
        String endereco,
        String telefone,
        LocalDate dataContrato,
        @NotBlank(message = "Cliente deve ter cpf ou cnpj") String registro,
        String banco
) {
    public ClienteDTO(Cliente novoCliente) {
        this(
                novoCliente.getNome(),
                novoCliente.getEndereco(),
                novoCliente.getTelefone(),
                novoCliente.getDataVencimentoContrato(),
                novoCliente.getRegistro(),
                novoCliente.getBanco()
        );
    }
}
