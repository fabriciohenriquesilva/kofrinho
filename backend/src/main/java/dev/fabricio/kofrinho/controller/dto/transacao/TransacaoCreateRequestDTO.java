package dev.fabricio.kofrinho.controller.dto.transacao;

import dev.fabricio.kofrinho.controller.dto.transacao.parcela.ParcelaCreateRequestDTO;
import dev.fabricio.kofrinho.model.TipoTransacaoEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class TransacaoCreateRequestDTO {

    @NotBlank
    private String descricao;

    @NotNull
    private LocalDate data;

    @NotNull
    private Integer credorId;

    @NotNull
    private Integer categoriaId;

    @NotNull
    private TipoTransacaoEnum tipoTransacao;

    @NotNull
    private Integer quantidadeParcelas;

    @NotNull
    private List<ParcelaCreateRequestDTO> parcelaList;

}
