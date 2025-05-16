package dev.gustavorosa.cobranca_cp.model;

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
    private String cpfOuCnpj;
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
        this.cpfOuCnpj = cpfOuCnpj;
        this.banco = banco;
    }

    public static Cliente registrar() {
        return new Cliente(UUID.randomUUID());
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

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }
}
