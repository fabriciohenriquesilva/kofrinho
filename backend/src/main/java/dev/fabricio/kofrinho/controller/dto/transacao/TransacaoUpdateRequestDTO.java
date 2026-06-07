package dev.fabricio.kofrinho.controller.dto.transacao;

import dev.fabricio.kofrinho.common.Identifiable;
import dev.fabricio.kofrinho.controller.dto.transacao.parcela.ParcelaUpdateRequestDTO;
import dev.fabricio.kofrinho.model.TipoTransacaoEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TransacaoUpdateRequestDTO implements Identifiable {

    @NotNull
    private Integer id;

    @NotBlank
    private String descricao;

    @NotNull
    private Integer credorId;

    @NotNull
    private Integer categoriaId;

    @NotNull
    private TipoTransacaoEnum tipoTransacao;

    @NotNull
    private List<ParcelaUpdateRequestDTO> parcelaList;

}
