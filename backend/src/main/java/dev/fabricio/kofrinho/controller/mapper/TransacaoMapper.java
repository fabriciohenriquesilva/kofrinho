package dev.fabricio.kofrinho.controller.mapper;

import dev.fabricio.kofrinho.common.MapperContract;
import dev.fabricio.kofrinho.controller.dto.transacao.TransacaoCreateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.transacao.TransacaoResponseDTO;
import dev.fabricio.kofrinho.controller.dto.transacao.TransacaoUpdateRequestDTO;
import dev.fabricio.kofrinho.model.Transacao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CategoriaMapper.class, CredorMapper.class, ParcelaMapper.class})
public interface TransacaoMapper extends MapperContract<Transacao, TransacaoCreateRequestDTO, TransacaoUpdateRequestDTO, TransacaoResponseDTO> {

    @Mapping(source = "credorId", target = "credor")
    @Mapping(source = "categoriaId", target = "categoria")
    Transacao fromCreateDTO(TransacaoCreateRequestDTO createRequestDTO);

    @Mapping(source = "credorId", target = "credor")
    @Mapping(source = "categoriaId", target = "categoria")
    Transacao fromUpdateDTO(TransacaoUpdateRequestDTO updateRequestDTO);

    TransacaoResponseDTO toReponse(Transacao entity);

    default Transacao fromId(Integer id) {
        if (id == null) {
            return null;
        }

        Transacao transacao = new Transacao();
        transacao.setId(id);

        return transacao;
    }

}
