package com.qac.software.hallazgos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.qac.software.conexion.Conexion;

public class HallazgoDAO {

    private Connection conexion;

    public HallazgoDAO() {
        conexion = Conexion.getConexion();
    }

    public boolean registrarHallazgo(Hallazgo h) {
        String sql = "INSERT INTO hallazgos (codigo, descripcion, proceso, clasificacion, estado, fecha_hallazgo, fecha_cierre) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, h.getCodigo());
            stmt.setString(2, h.getDescripcion());
            stmt.setString(3, h.getProceso());
            stmt.setString(4, h.getClasificacion());
            stmt.setString(5, h.getEstado());
            stmt.setString(6, h.getFechaHallazgo());
            stmt.setString(7, h.getFechaCierre());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al registrar hallazgo: " + e.getMessage());
            return false;
        }
    }

    public List<Hallazgo> listarHallazgos() {
        List<Hallazgo> lista = new ArrayList<>();
        String sql = "SELECT * FROM hallazgos";

        try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Hallazgo h = new Hallazgo();
                h.setId(rs.getInt("id"));
                h.setCodigo(rs.getString("codigo"));
                h.setDescripcion(rs.getString("descripcion"));
                h.setProceso(rs.getString("proceso"));
                h.setClasificacion(rs.getString("clasificacion"));
                h.setEstado(rs.getString("estado"));
                h.setFechaHallazgo(rs.getString("fecha_hallazgo"));
                h.setFechaCierre(rs.getString("fecha_cierre"));

                lista.add(h);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar hallazgos: " + e.getMessage());
        }

        return lista;
    }
}
