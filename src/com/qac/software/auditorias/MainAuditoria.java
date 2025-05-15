package com.qac.software.auditorias;

public class MainAuditoria {
    public static void main(String[] args) {
        AuditoriaDAO dao = new AuditoriaDAO();

        // Insertar prueba
        Auditoria nueva = new Auditoria(0, "123456", "Interna", "ISO 9001", "2025-05-20", "2025-05-25", "Presencial", "Pedro Sánchez", "Auditoría inicial");
        boolean resultado = dao.insertarAuditoria(nueva);

        if (resultado) {
            System.out.println("Auditoría registrada con éxito.");
        } else {
            System.out.println("Fallo al registrar auditoría.");
        }

        // Mostrar registros
        System.out.println("Listado de auditorías:");
        for (Auditoria a : dao.listarAuditorias()) {
            System.out.println("→ " + a.getId() + " - Cliente: " + a.getClienteId() + " | Norma: " + a.getNorma());
        }
    }
}
