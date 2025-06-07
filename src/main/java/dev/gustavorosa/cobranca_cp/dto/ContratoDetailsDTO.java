package dev.gustavorosa.cobranca_cp.dto;

import dev.gustavorosa.cobranca_cp.model.Cliente;
import dev.gustavorosa.cobranca_cp.model.Contrato;
import dev.gustavorosa.cobranca_cp.model.Pagamento;

import java.util.List;

public record ContratoDetailsDTO(
        Long id,
        String nomeCliente,
        String nomeMensalista,
        String registroMensalista,
        String telefoneMensalista,
        Integer parcelas,
        List<Pagamento> pagamentos
) {

    public ContratoDetailsDTO(Contrato contrato){
        this(
                contrato.getId(),
                contrato.getCliente().getNome(),
                contrato.getNomeMensalista(),
                contrato.getRegistroMensalista(),
                contrato.getTelefoneMensalista(),
                contrato.getParcelas(),
                contrato.getPagamentos()
        );
    }
}
