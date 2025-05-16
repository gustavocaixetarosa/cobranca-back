package dev.gustavorosa.cobranca_cp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "contratos")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;
    @NotBlank
    private String nomeMensalista;
    private String registroMensalista;
    private String telefoneMensalista;
    private Integer duracaoEmMeses;
    private LocalDate diaVencimento;
    private BigDecimal valorMensal;
    @OneToMany(mappedBy = "contrato", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pagamento> pagamentos;


    public Contrato() {
        super();
    }

    public Contrato(Long id, String nomeMensalista, String registroMensalista, String telefoneMensalista, Integer duracaoEmMeses, LocalDate diaVencimento, BigDecimal valorMensal, List<Pagamento> pagamentos) {
        this.id = id;
        this.nomeMensalista = nomeMensalista;
        this.registroMensalista = registroMensalista;
        this.telefoneMensalista = telefoneMensalista;
        this.duracaoEmMeses = duracaoEmMeses;
        this.diaVencimento = diaVencimento;
        this.valorMensal = valorMensal;
        this.pagamentos = pagamentos;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeMensalista() {
        return nomeMensalista;
    }

    public void setNomeMensalista(String nomeMensalista) {
        this.nomeMensalista = nomeMensalista;
    }

    public String getRegistroMensalista() {
        return registroMensalista;
    }

    public void setRegistroMensalista(String registroMensalista) {
        this.registroMensalista = registroMensalista;
    }

    public String getTelefoneMensalista() {
        return telefoneMensalista;
    }

    public void setTelefoneMensalista(String telefoneMensalista) {
        this.telefoneMensalista = telefoneMensalista;
    }

    public Integer getDuracaoEmMeses() {
        return duracaoEmMeses;
    }

    public void setDuracaoEmMeses(Integer duracaoEmMeses) {
        this.duracaoEmMeses = duracaoEmMeses;
    }

    public LocalDate getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(LocalDate diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public BigDecimal getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(BigDecimal valorMensal) {
        this.valorMensal = valorMensal;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }
}
