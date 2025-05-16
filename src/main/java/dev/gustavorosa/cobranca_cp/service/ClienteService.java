package dev.gustavorosa.cobranca_cp.service;

import dev.gustavorosa.cobranca_cp.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


}
