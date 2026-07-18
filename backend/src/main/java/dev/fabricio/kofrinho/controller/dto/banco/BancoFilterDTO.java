package dev.fabricio.kofrinho.controller.dto.banco;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BancoFilterDTO {

    private Integer id;

    private Integer idDe;

    private Integer idAte;

    private String codigo;

    private String nome;

    private String nomeLike;

    private Integer limit;

}
