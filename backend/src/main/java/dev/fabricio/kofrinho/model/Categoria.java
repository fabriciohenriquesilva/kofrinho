package dev.fabricio.kofrinho.model;

import dev.fabricio.kofrinho.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "categoria")
@Getter
@Setter
public class Categoria extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String nome;

    private Integer codigo;

    @ManyToOne
    @JoinColumn(name = "pai")
    private Categoria pai;

    @ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;

    @Column(name = "datacriacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @Version
    private Integer version = 0;
}
