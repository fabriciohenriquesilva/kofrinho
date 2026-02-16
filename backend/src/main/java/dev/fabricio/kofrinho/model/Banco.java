package dev.fabricio.kofrinho.model;

import dev.fabricio.kofrinho.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "banco")
@Getter
@Setter
public class Banco extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 10)
    private String codigo;

    @Column(name = "datacriacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @Version
    private Integer version = 0;

}
