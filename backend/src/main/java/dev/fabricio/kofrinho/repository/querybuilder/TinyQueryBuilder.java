package dev.fabricio.kofrinho.repository.querybuilder;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TinyQueryBuilder<T> {

    private String alias;
    private Class<T> clazz;
    private String hql;
    private Map<String, Object> params = new HashMap<>();
    private List<String> conditions = new ArrayList<>();
    private TypedQuery<T> query;
    private int countParam = 0;

    private final EntityManager entityManager;

    public TinyQueryBuilder(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public TinyQueryBuilder<T> from(Class<T> clazz, String alias) {
        this.clazz = clazz;
        this.alias = alias;
        this.hql = "SELECT %s FROM %s %s".formatted(alias, clazz.getSimpleName(), alias);

        return this;
    }

    public List<T> list(int firstResult, int maxResults) {
        return query.setFirstResult(firstResult)
                .setMaxResults(maxResults)
                .getResultList();
    }

    public TinyQueryBuilder<T> build() {
        if (!conditions.isEmpty()) {
            hql = hql + " WHERE " + String.join(" AND ", conditions);
        }
        query = entityManager.createQuery(hql, clazz);
        params.forEach(query::setParameter);

        return this;
    }

    public TinyQueryBuilder<T> andEquals(String field, Object value) {
        if (value != null) {
            String param = nextParam();
            conditions.add(alias + "." + field + " = :" + param);
            params.put(param, value);
        }

        return this;
    }

    public TinyQueryBuilder<T> andBetween(String field, Object value1, Object value2) {
        if (value1 != null && value2 != null) {
            String param1 = nextParam();
            String param2 = nextParam();
            conditions.add("%s.%s BETWEEN :%s AND :%s".formatted(alias, field, param1, param2));
            params.put(param1, value1);
            params.put(param2, value2);
        }

        if (value1 == null && value2 != null) {
            String param2 = nextParam();
            conditions.add("%s.%s <= :%s".formatted(alias, field, param2));
            params.put(param2, value2);
        }

        if (value1 != null && value2 == null) {
            String param1 = nextParam();
            conditions.add("%s.%s >= :%s".formatted(alias, field, param1));
            params.put(param1, value1);
        }

        return this;
    }

    public TinyQueryBuilder<T> andLike(String field, Object value) {
        if (value != null) {
            String param = nextParam();
            conditions.add("UPPER(%s.%s) LIKE :%s".formatted(alias, field, param));
            params.put(param, "%".concat(value.toString().toUpperCase()).concat("%"));
        }

        return this;
    }

    private String nextParam() {
        return "param" + countParam++;
    }

}
