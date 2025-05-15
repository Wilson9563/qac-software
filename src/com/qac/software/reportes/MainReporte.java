package com.qac.software.reportes;

public class MainReporte {
    public static void main(String[] args) {
        ReporteDAO dao = new ReporteDAO();

        Reporte filtro = new Reporte("Auditorias", "2025-01-01", "2025-12-31", "Abierto");

        System.out.println("Reporte de Auditorías:");
        for (String reporte : dao.generarReporteAuditorias(filtro)) {
            System.out.println(reporte);
        }
    }
}
