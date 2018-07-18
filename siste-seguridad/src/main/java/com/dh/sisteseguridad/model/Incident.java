package com.dh.sisteseguridad.model;

import javax.persistence.Entity;

@Entity
public class Incident extends ModelBase {
    private String code;
    private String nombre;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
