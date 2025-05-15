package com.qac.software.reportes;

public class Reporte {
    private String tipoReporte;
    private String fechaInicio;
    private String fechaFin;
    private String estado;

    public Reporte() {}

    public Reporte(String tipoReporte, String fechaInicio, String fechaFin, String estado) {
        this.tipoReporte = tipoReporte;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    // Getters y setters aquí
}
