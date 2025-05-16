package dev.gustavorosa.cobranca_cp.model;

import dev.gustavorosa.cobranca_cp.dto.ClienteDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    private String nome;
    private String endereco;
    @NotNull
    private String telefone;
    private LocalDate dataVencimentoContrato;
    @NotNull
    private String registro;
    private String banco;

    public Cliente(){
        super();
    }

    public Cliente(UUID id){
        this.id = id;
    }

    public Cliente(UUID id, String nome, String endereco, String telefone, LocalDate dataVencimentoContrato, String cpfOuCnpj, String banco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataVencimentoContrato = dataVencimentoContrato;
        this.registro = cpfOuCnpj;
        this.banco = banco;
    }

    public Cliente(ClienteDTO clienteDTO) {
        this.nome = clienteDTO.nome();
        this.endereco = clienteDTO.endereco();
        this.telefone = clienteDTO.telefone();
        this.dataVencimentoContrato = clienteDTO.dataContrato();
        this.registro = clienteDTO.registro();
        this.banco = clienteDTO.banco();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataVencimentoContrato() {
        return dataVencimentoContrato;
    }

    public void setDataVencimentoContrato(LocalDate dataVencimentoContrato) {
        this.dataVencimentoContrato = dataVencimentoContrato;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public boolean valido() {
        return true;
    }
}
