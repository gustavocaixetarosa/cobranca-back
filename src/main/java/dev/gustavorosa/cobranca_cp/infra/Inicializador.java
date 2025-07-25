package dev.gustavorosa.cobranca_cp.infra;

import dev.gustavorosa.cobranca_cp.service.AtualizacaoPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Inicializador {

    private final AtualizacaoPagamentoService atualizacaoPagamentoService;

    @Autowired
    public Inicializador(AtualizacaoPagamentoService atualizacaoPagamentoService) {
        this.atualizacaoPagamentoService = atualizacaoPagamentoService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void aoIniciarAplicacao() {
        atualizacaoPagamentoService.atualizarSituacaoSeNecessario();
    }
}

