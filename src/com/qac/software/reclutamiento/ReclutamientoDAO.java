package com.qac.software.reclutamiento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.qac.software.conexion.Conexion;

public class ReclutamientoDAO {

    private Connection conexion;

    public ReclutamientoDAO() {
        conexion = Conexion.getConexion();
    }

    public boolean insertarProceso(Reclutamiento r) {
        String sql = "INSERT INTO reclutamientos (cliente_id, tipo_cargo, tipo_plan, fecha_inicio, fecha_fin, pruebas, reclutador) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, r.getClienteId());
            stmt.setString(2, r.getTipoCargo());
            stmt.setString(3, r.getTipoPlan());
            stmt.setString(4, r.getFechaInicio());
            stmt.setString(5, r.getFechaFin());
            stmt.setString(6, r.getPruebas());
            stmt.setString(7, r.getReclutador());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar proceso: " + e.getMessage());
            return false;
        }
    }

    public List<Reclutamiento> listarProcesos() {
        List<Reclutamiento> lista = new ArrayList<>();
        String sql = "SELECT * FROM reclutamientos";

        try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Reclutamiento r = new Reclutamiento();
                r.setId(rs.getInt("id"));
                r.setClienteId(rs.getString("cliente_id"));
                r.setTipoCargo(rs.getString("tipo_cargo"));
                r.setTipoPlan(rs.getString("tipo_plan"));
                r.setFechaInicio(rs.getString("fecha_inicio"));
                r.setFechaFin(rs.getString("fecha_fin"));
                r.setPruebas(rs.getString("pruebas"));
                r.setReclutador(rs.getString("reclutador"));

                lista.add(r);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar procesos: " + e.getMessage());
        }

        return lista;
    }
}
