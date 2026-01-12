package com.docencia.tasks.adapters.in.api;

import java.util.Objects;

public class TaskRequest {

    private Long identificador;
    private String titulo;
    private String descripcion;
    private boolean completado;

    public TaskRequest() {
    }

    public TaskRequest(Long identificador) {
        this.identificador = identificador;
    }

    public TaskRequest(Long identificador, String titulo, String descripcion, boolean completado) {
        this.identificador = identificador;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.completado = completado;
    }

    public Long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Long identificador) {
        this.identificador = identificador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TaskRequest other = (TaskRequest) obj;
        return Objects.equals(identificador, other.identificador);
    }
}
