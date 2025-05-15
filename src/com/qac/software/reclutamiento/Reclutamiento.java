package com.qac.software.reclutamiento;

public class Reclutamiento {
    private int id;
    private String clienteId;
    private String tipoCargo;
    private String tipoPlan;
    private String fechaInicio;
    private String fechaFin;
    private String pruebas;
    private String reclutador;

    public Reclutamiento() {}

    public Reclutamiento(int id, String clienteId, String tipoCargo, String tipoPlan, String fechaInicio, String fechaFin, String pruebas, String reclutador) {
        this.id = id;
        this.clienteId = clienteId;
        this.tipoCargo = tipoCargo;
        this.tipoPlan = tipoPlan;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.pruebas = pruebas;
        this.reclutador = reclutador;
    }

    // Getters y setters (puedo generarlos si los necesitas)
}
