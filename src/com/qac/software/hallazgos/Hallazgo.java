package com.qac.software.hallazgos;

public class Hallazgo {
    private int id;
    private String codigo;
    private String descripcion;
    private String proceso;
    private String clasificacion;
    private String estado;
    private String fechaHallazgo;
    private String fechaCierre;

    public Hallazgo() {}

    public Hallazgo(int id, String codigo, String descripcion, String proceso, String clasificacion, String estado, String fechaHallazgo, String fechaCierre) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.proceso = proceso;
        this.clasificacion = clasificacion;
        this.estado = estado;
        this.fechaHallazgo = fechaHallazgo;
        this.fechaCierre = fechaCierre;
    }

    // Getters y setters (si los necesitas, los generamos luego)
}
