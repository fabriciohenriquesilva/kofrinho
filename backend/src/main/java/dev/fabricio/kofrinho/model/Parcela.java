package dev.fabricio.kofrinho.model;

import dev.fabricio.kofrinho.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "transacao")
@Getter
@Setter
public class Parcela extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer sequencial;

    private LocalDate vencimento;

    private LocalDate pagamento;

    @Column(name = "valorbruto")
    private BigDecimal valorBruto;

    private BigDecimal desconto;

    @Column(name = "valorliquido")
    private BigDecimal valorLiquido;

//    @Enumerated(EnumType.STRING)
//    @Column(name = "tipopagamento")
//    private TipoPagamento tipoPagamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "formapagamento")
    private FormaPagamento formaPagamento;

    @ManyToOne
    @JoinColumn(name = "transacao")
    private Transacao transacao;

    @ManyToOne
    @JoinColumn(name = "conta")
    private Conta conta;

    @Column(name = "datacriacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @Version
    private Integer version = 0;

}
