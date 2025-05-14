package com.qac.software.dao;

import com.qac.software.database.Conexion;
import com.qac.software.modelo.Usuario;

import java.sql.*;

public class UsuarioDAO {

    public void insertarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (id, nombres, apellidos, email, rol) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuario.getId());
            stmt.setString(2, usuario.getNombres());
            stmt.setString(3, usuario.getApellidos());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getRol());
            stmt.executeUpdate();
            System.out.println("Usuario insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    public Usuario consultarUsuarioPorId(int id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                    rs.getInt("id"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getString("email"),
                    rs.getString("rol")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }
        return null;
    }

    public void actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombres = ?, apellidos = ?, email = ?, rol = ? WHERE id = ?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombres());
            stmt.setString(2, usuario.getApellidos());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getRol());
            stmt.setInt(5, usuario.getId());
            stmt.executeUpdate();
            System.out.println("Usuario actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    public void eliminarUsuario(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Usuario eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }
}
