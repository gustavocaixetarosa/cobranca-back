package dev.gustavorosa.cobranca_cp.service;

import dev.gustavorosa.cobranca_cp.dto.ClienteDTO;
import dev.gustavorosa.cobranca_cp.model.Cliente;
import dev.gustavorosa.cobranca_cp.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente registraCliente(ClienteDTO clienteDTO){
        Cliente novoCliente = new Cliente(clienteDTO);
        if(!novoCliente.valido())
            throw new IllegalArgumentException("Dados do cliente sao invalidos.");
        return clienteRepository.save(novoCliente);
    }
}
