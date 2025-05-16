package dev.gustavorosa.cobranca_cp.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pagamentos")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contrato_id", nullable = false)
    private Contrato contrato;
    private BigDecimal valor;
    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
    @Enumerated(EnumType.STRING)
    private SituacaoPagamento status;
    private String observacao;

    public Pagamento() {
    }

    public Pagamento(Long id, Contrato contrato, BigDecimal valor, LocalDate dataVencimento, LocalDate dataPagamento, SituacaoPagamento status, String observacao) {
        this.id = id;
        this.contrato = contrato;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.status = status;
        this.observacao = observacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Contrato getIdContrato() {
        return contrato;
    }

    public void setIdContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public SituacaoPagamento getStatus() {
        return status;
    }

    public void setStatus(SituacaoPagamento status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
