package dev.fabricio.kofrinho.controller.dto.transacao;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import dev.fabricio.kofrinho.controller.dto.categoria.CategoriaResponseDTO;
import dev.fabricio.kofrinho.controller.dto.credor.CredorResponseDTO;
import dev.fabricio.kofrinho.controller.dto.transacao.parcela.ParcelaResponseDTO;
import dev.fabricio.kofrinho.model.TipoTransacaoEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonPropertyOrder({"id", "descricao", "tipoTransacao", "credor", "categoria", "parcelaList"})
public class TransacaoResponseDTO {

    private Integer id;

    private String descricao;

    private TipoTransacaoEnum tipoTransacao;

    private CredorResponseDTO credor;

    private CategoriaResponseDTO categoria;

    private List<ParcelaResponseDTO> parcelaList;

}
