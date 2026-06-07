package dev.fabricio.kofrinho.model;

import dev.fabricio.kofrinho.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "transacao")
@Getter
@Setter
public class Transacao extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String descricao;

    @Column(name = "data", nullable = false)
    private LocalDate data;

    @ManyToOne
    private Credor credor;

    @ManyToOne
    @JoinColumn(name = "categoria")
    private Categoria categoria;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoTransacao tipoTransacao;

    @Column(name = "qtdeparcelas")
    private Integer quantidadeParcelas;

    @ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;

    @Column(name = "datacriacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @OneToMany(mappedBy = "transacao", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Parcela> parcelaList;

    @Version
    private Integer version = 0;

}
