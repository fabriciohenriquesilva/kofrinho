package dev.fabricio.kofrinho.common;

import dev.fabricio.kofrinho.exception.ServiceException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @deprecated
 */
@Component
public class RelationshipResolver {

    private final ApplicationContext applicationContext;

    public RelationshipResolver(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public <T extends BaseEntity, D> void execute(T entity, D dto) {
        if (!(dto instanceof RelationshipAware relationshipAware)) {
            return;
        }

        try {
            for (Map.Entry<String, RelationshipAware.RelationshipConfig> entry : relationshipAware.getRelationshipConfig().entrySet()) {
                String entityField = entry.getKey();
                RelationshipAware.RelationshipConfig config = entry.getValue();

                try {
                    Object idValue = getIdValue(dto, config.idFieldName());

                    if (idValue == null) {
                        return;
                    }

                    // Buscar o service correspondente
                    Object service = applicationContext.getBean(config.serviceClass());

                    // Chamar o FindById
                    Method findByIdMethod = config.serviceClass().getMethod("findById", Object.class);
                    Object relatedEntity = findByIdMethod.invoke(service, idValue);

                    // Atribuir a entidade ao relacionamento
                    setFieldValue(entity, entityField, relatedEntity);

                } catch (Exception e) {
                    throw new ServiceException("Erro ao resolver relacionamento: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            throw new ServiceException("Erro ao resolver relacionamentos: Classe [%s] %s".formatted(entity.getClass().getName(), e.getMessage()));
        }
    }

    private Object getIdValue(Object dto, String idFieldName) throws ReflectiveOperationException {
        String getterName = "get" + idFieldName.substring(0, 1).toUpperCase() + idFieldName.substring(1);
        Method method = dto.getClass().getMethod(getterName);
        return method.invoke(dto);
    }

    private void setFieldValue(Object entity, String fieldName, Object value) throws ReflectiveOperationException {
        String setterName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

        // Buscar pelo setter
        Method[] methods = entity.getClass().getMethods();
        for (Method method : methods) {
            if (method.getName().equals(setterName) && method.getParameterCount() == 1) {
                method.invoke(entity, value);
                return;
            }
        }

        throw new NoSuchMethodException("Setter não encontrado: " + setterName);
    }

}
