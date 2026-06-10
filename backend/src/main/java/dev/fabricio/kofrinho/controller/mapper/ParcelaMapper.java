package dev.fabricio.kofrinho.controller.mapper;

import dev.fabricio.kofrinho.common.MapperContract;
import dev.fabricio.kofrinho.controller.dto.transacao.parcela.ParcelaCreateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.transacao.parcela.ParcelaResponseDTO;
import dev.fabricio.kofrinho.controller.dto.transacao.parcela.ParcelaUpdateRequestDTO;
import dev.fabricio.kofrinho.model.Parcela;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = ContaMapper.class)
public interface ParcelaMapper extends MapperContract<Parcela, ParcelaCreateRequestDTO, ParcelaUpdateRequestDTO, ParcelaResponseDTO> {

    @Mapping(source = "contaId", target = "conta")
    Parcela fromCreateDTO(ParcelaCreateRequestDTO createRequestDTO);

    Parcela fromUpdateDTO(ParcelaUpdateRequestDTO updateRequestDTO);

    @Mapping(target = "conta", ignore = true)
    void updateEntity(ParcelaUpdateRequestDTO updateRequestDTO, @MappingTarget Parcela entity);

    ParcelaResponseDTO toResponse(Parcela entity);

    Parcela fromId(Integer id);
}
