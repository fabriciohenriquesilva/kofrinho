package dev.fabricio.kofrinho.common;

import java.time.LocalDateTime;

public abstract class BaseEntity {

    public abstract Integer getId();

    public abstract LocalDateTime getDataCriacao();

    public abstract void setDataCriacao(LocalDateTime now);

    public abstract Integer getVersion();
}
