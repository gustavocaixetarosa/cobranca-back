package dev.gustavorosa.cobranca_cp.domain.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.List;

import dev.gustavorosa.cobranca_cp.domain.model.Cliente;
import dev.gustavorosa.cobranca_cp.domain.model.Contrato;

public record ClienteDTO(
        Long id,
        @NotBlank(message = "Nome do cliente nao pode estar vazio.") String nome,
        String endereco,
        String telefone,
        LocalDate dataContrato,
        @NotBlank(message = "Cliente deve ter cpf ou cnpj") String registro,
        String banco,
        List<Contrato> contratos
) {
    public ClienteDTO(Cliente novoCliente) {
        this(
                novoCliente.getId(),
                novoCliente.getNome(),
                novoCliente.getEndereco(),
                novoCliente.getTelefone(),
                novoCliente.getDataVencimentoContrato(),
                novoCliente.getRegistro(),
                novoCliente.getBanco(),
                novoCliente.getContratos()
        );
    }
}
