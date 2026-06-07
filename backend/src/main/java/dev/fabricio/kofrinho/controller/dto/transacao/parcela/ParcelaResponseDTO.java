package dev.fabricio.kofrinho.controller.dto.transacao.parcela;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import dev.fabricio.kofrinho.controller.dto.conta.ContaResponseDTO;
import dev.fabricio.kofrinho.model.FormaPagamentoEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@JsonPropertyOrder({"id", "sequencial", "vencimento", "pagamento", "formaPagamento", "valorBruto", "desconto", "valorLiquido", "conta"})
public class ParcelaResponseDTO {

    private Integer id;

    private Integer sequencial;

    private LocalDate vencimento;

    private LocalDate pagamento;

    private BigDecimal valorBruto;

    private BigDecimal desconto;

    private BigDecimal valorLiquido;

    private FormaPagamentoEnum formaPagamento;

    private ContaResponseDTO conta;

}
