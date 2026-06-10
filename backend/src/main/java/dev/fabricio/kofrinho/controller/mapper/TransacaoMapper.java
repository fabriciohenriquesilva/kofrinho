package dev.fabricio.kofrinho.controller.mapper;

import dev.fabricio.kofrinho.common.MapperContract;
import dev.fabricio.kofrinho.controller.dto.transacao.TransacaoCreateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.transacao.TransacaoResponseDTO;
import dev.fabricio.kofrinho.controller.dto.transacao.TransacaoUpdateRequestDTO;
import dev.fabricio.kofrinho.model.Transacao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {CategoriaMapper.class, CredorMapper.class, ParcelaMapper.class})
public interface TransacaoMapper extends MapperContract<Transacao, TransacaoCreateRequestDTO, TransacaoUpdateRequestDTO, TransacaoResponseDTO> {

    @Mapping(source = "credorId", target = "credor")
    @Mapping(source = "categoriaId", target = "categoria")
    Transacao fromCreateDTO(TransacaoCreateRequestDTO createRequestDTO);

    @Mapping(target = "credor", ignore = true)
    @Mapping(target = "categoria", ignore = true)
    @Mapping(target = "parcelaList", ignore = true)
    void updateEntity(TransacaoUpdateRequestDTO updateRequestDTO, @MappingTarget Transacao entity);

    TransacaoResponseDTO toResponse(Transacao entity);

    Transacao fromId(Integer id);

}
