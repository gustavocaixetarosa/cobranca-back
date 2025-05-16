package dev.gustavorosa.cobranca_cp;

import dev.gustavorosa.cobranca_cp.model.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient.ResponseSpec;

import java.util.UUID;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClienteTest {

    @Value(value = "${local.server.port}")
    private int port;

    @Test
    public void dadoUmCliente_QuandoEuSubmeto() throws Exception{
        ResponseSpec response = WebTestClient.
                bindToServer()
                    .baseUrl("http://localhost:" + port + "/clientes")
                    .build()
                .post()
                .exchange();
        
        deveRegistrarNovoCliente(response);
        Cliente clienteResposta = deveRetornarNovoId(response);
        deveRetornarOndeLocalizarNovoCliente(response, clienteResposta);
    }

    private Cliente deveRetornarNovoId(ResponseSpec response) {
        return response
                .expectBody(Cliente.class)
                .value(cliente -> {
                    Assertions.assertNotEquals(new UUID(0, 0), cliente.getId());
                    Assertions.assertNotNull(cliente.getId());
                })
                .returnResult()
                .getResponseBody();
    }

    private void deveRegistrarNovoCliente(ResponseSpec response) {
        response
            .expectStatus()
            .isCreated();
    }

    private void deveRetornarOndeLocalizarNovoCliente(ResponseSpec response, Cliente novoCliente){
        response
                .expectHeader()
                .location(baseUri() + "/clientes/" + novoCliente.getId());
    }

    private String baseUri() {
        return "http://localhost:" + port;
    }
}
