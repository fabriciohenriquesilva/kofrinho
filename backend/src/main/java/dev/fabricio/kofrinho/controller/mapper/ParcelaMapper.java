package dev.fabricio.kofrinho.controller.mapper;

import dev.fabricio.kofrinho.common.MapperContract;
import dev.fabricio.kofrinho.controller.dto.transacao.parcela.ParcelaCreateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.transacao.parcela.ParcelaResponseDTO;
import dev.fabricio.kofrinho.controller.dto.transacao.parcela.ParcelaUpdateRequestDTO;
import dev.fabricio.kofrinho.model.Parcela;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ContaMapper.class)
public interface ParcelaMapper extends MapperContract<Parcela, ParcelaCreateRequestDTO, ParcelaUpdateRequestDTO, ParcelaResponseDTO> {

    @Mapping(source = "contaId", target = "conta")
    Parcela fromCreateDTO(ParcelaCreateRequestDTO createRequestDTO);

    @Mapping(source = "contaId", target = "conta")
    Parcela fromUpdateDTO(ParcelaUpdateRequestDTO updateRequestDTO);

    ParcelaResponseDTO toResponse(Parcela entity);

    Parcela fromId(Integer id);
}
