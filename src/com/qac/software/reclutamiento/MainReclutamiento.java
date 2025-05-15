package com.qac.software.reclutamiento;

public class MainReclutamiento {
    public static void main(String[] args) {
        ReclutamientoDAO dao = new ReclutamientoDAO();

        Reclutamiento nuevo = new Reclutamiento(0, "123456", "Operativo", "Básico", "2025-05-10", "2025-05-20", "Entrevistas, Visita domiciliaria", "Laura Gómez");

        if (dao.insertarProceso(nuevo)) {
            System.out.println("Proceso de reclutamiento registrado con éxito.");
        } else {
            System.out.println("Fallo al registrar proceso.");
        }

        System.out.println("Lista de procesos:");
        for (Reclutamiento r : dao.listarProcesos()) {
            System.out.println("→ Cliente: " + r.getClienteId() + " | Cargo: " + r.getTipoCargo());
        }
    }
}
