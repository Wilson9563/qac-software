package com.qac.software.auditorias;

public class Auditoria {
    private int id;
    private String clienteId;
    private String tipo;
    private String norma;
    private String fechaInicio;
    private String fechaFin;
    private String modalidad;
    private String auditorAsignado;
    private String observaciones;

    public Auditoria(int id, String clienteId, String tipo, String norma, String fechaInicio, String fechaFin, String modalidad, String auditorAsignado, String observaciones) {
        this.id = id;
        this.clienteId = clienteId;
        this.tipo = tipo;
        this.norma = norma;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.modalidad = modalidad;
        this.auditorAsignado = auditorAsignado;
        this.observaciones = observaciones;
    }

    public Auditoria() {}

    // Getters y setters
    // (puedo dártelos generados si los necesitas)
}
