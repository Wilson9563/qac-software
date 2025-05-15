package com.qac.software.auditorias;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.qac.software.conexion.Conexion;

public class AuditoriaDAO {

    private Connection conexion;

    public AuditoriaDAO() {
        conexion = Conexion.getConexion();
    }

    public boolean insertarAuditoria(Auditoria auditoria) {
        String sql = "INSERT INTO auditorias (cliente_id, tipo, norma, fecha_inicio, fecha_fin, modalidad, auditor_asignado, observaciones) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, auditoria.getClienteId());
            stmt.setString(2, auditoria.getTipo());
            stmt.setString(3, auditoria.getNorma());
            stmt.setString(4, auditoria.getFechaInicio());
            stmt.setString(5, auditoria.getFechaFin());
            stmt.setString(6, auditoria.getModalidad());
            stmt.setString(7, auditoria.getAuditorAsignado());
            stmt.setString(8, auditoria.getObservaciones());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar auditoría: " + e.getMessage());
            return false;
        }
    }

    public List<Auditoria> listarAuditorias() {
        List<Auditoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM auditorias";

        try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Auditoria a = new Auditoria();
                a.setId(rs.getInt("id"));
                a.setClienteId(rs.getString("cliente_id"));
                a.setTipo(rs.getString("tipo"));
                a.setNorma(rs.getString("norma"));
                a.setFechaInicio(rs.getString("fecha_inicio"));
                a.setFechaFin(rs.getString("fecha_fin"));
                a.setModalidad(rs.getString("modalidad"));
                a.setAuditorAsignado(rs.getString("auditor_asignado"));
                a.setObservaciones(rs.getString("observaciones"));

                lista.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar auditorías: " + e.getMessage());
        }

        return lista;
    }

    // Actualizar y eliminar también puedo incluirlos si me das luz verde
}
