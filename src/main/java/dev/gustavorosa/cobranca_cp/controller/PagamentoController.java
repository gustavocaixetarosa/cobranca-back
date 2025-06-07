package dev.gustavorosa.cobranca_cp.controller;

import dev.gustavorosa.cobranca_cp.dto.PagamentoDTO;
import dev.gustavorosa.cobranca_cp.model.Pagamento;
import dev.gustavorosa.cobranca_cp.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping
    public ResponseEntity<List<PagamentoDTO>> recuperarPagamentos(){
       List<Pagamento> pagamentosRecuperados = pagamentoService.recuperarTsssssssssssssssssssssssssssssssssssssssssssodos();
       List<PagamentoDTO> dtos = pagamentosRecuperados.stream().map(PagamentoDTO::new).toList();
       return ResponseEntity.ok(dtos);
    }
}
