package com.qac.software.hallazgos;

public class MainHallazgo {
    public static void main(String[] args) {
        HallazgoDAO dao = new HallazgoDAO();

        Hallazgo nuevo = new Hallazgo(0, "AUD-045-1", "No se evidenció registro de calibración de equipos críticos", "Producción", "No Conformidad Mayor", "Abierto", "2025-05-12", null);

        if (dao.registrarHallazgo(nuevo)) {
            System.out.println("Hallazgo registrado con éxito.");
        } else {
            System.out.println("Error al registrar hallazgo.");
        }

        System.out.println("Lista de hallazgos:");
        for (Hallazgo h : dao.listarHallazgos()) {
            System.out.println("→ Código: " + h.getCodigo() + " | Estado: " + h.getEstado());
        }
    }
}
