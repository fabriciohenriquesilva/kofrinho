package dev.fabricio.kofrinho.common;

import java.util.Map;

// TODO revisar depois se faz sentido o DTO conhecer a classe de Serviço

public interface RelationshipAware {

    record RelationshipConfig(String idFieldName, Class<?> serviceClass) {
    }

    Map<String, RelationshipConfig> getRelationshipConfig();

}
