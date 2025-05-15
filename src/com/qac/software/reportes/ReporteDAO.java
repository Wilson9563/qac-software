package com.qac.software.reportes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.qac.software.conexion.Conexion;

public class ReporteDAO {
    private Connection conexion;

    public ReporteDAO() {
        conexion = Conexion.getConexion();
    }

    public List<String> generarReporteAuditorias(Reporte filtro) {
        List<String> resultados = new ArrayList<>();
        String sql = "SELECT codigo, estado FROM auditorias WHERE fecha_inicio BETWEEN ? AND ? AND estado LIKE ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, filtro.getFechaInicio());
            stmt.setString(2, filtro.getFechaFin());
            stmt.setString(3, "%" + filtro.getEstado() + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String estado = rs.getString("estado");
                resultados.add("Auditoría " + codigo + " - Estado: " + estado);
            }
        } catch (SQLException e) {
            System.out.println("Error al generar reporte: " + e.getMessage());
        }
        return resultados;
    }
}
