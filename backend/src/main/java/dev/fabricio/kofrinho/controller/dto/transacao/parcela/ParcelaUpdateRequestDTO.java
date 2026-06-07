package dev.fabricio.kofrinho.controller.dto.transacao.parcela;

import dev.fabricio.kofrinho.common.Identifiable;
import dev.fabricio.kofrinho.model.FormaPagamentoEnum;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class ParcelaUpdateRequestDTO implements Identifiable {

    private Integer id;

    @NotNull
    private Integer sequencial;

    @NotNull
    private LocalDate vencimento;

    private LocalDate pagamento;

    private BigDecimal valorBruto;

    private BigDecimal desconto;

    @NotNull
    private BigDecimal valorLiquido;

    @NotNull
    private FormaPagamentoEnum formaPagamento;

    @NotNull
    private Integer contaId;
}
