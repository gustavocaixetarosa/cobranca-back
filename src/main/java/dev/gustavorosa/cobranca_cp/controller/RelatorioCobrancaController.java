package dev.gustavorosa.cobranca_cp.controller;

import dev.gustavorosa.cobranca_cp.service.RelatorioCobrancaService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/relatorios")
public class RelatorioCobrancaController {

  private final RelatorioCobrancaService relatorioCobrancaService;

  public RelatorioCobrancaController(RelatorioCobrancaService relatorioCobrancaService) {
    this.relatorioCobrancaService = relatorioCobrancaService;
  }

  @GetMapping("/clientes/{id}/cobrancas")
  public ResponseEntity<byte[]> gerarRelatorio(@PathVariable Long id) {
    byte[] pdf = relatorioCobrancaService.gerarRelatorioPorCliente(id);

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=relatorio_cliente_" + id + ".pdf")
        .contentType(MediaType.APPLICATION_PDF)
        .body(pdf);
  }
}
