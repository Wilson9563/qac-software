package com.qac.software.dao;

import com.qac.software.config.Conexion;
import com.qac.software.modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private Connection conn;

    public UsuarioDAO() {
        conn = Conexion.getConexion();
    }

    public void insertar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (id, nombres, apellidos, rol, ciudad, direccion, email, telefono, clave) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuario.getId());
            stmt.setString(2, usuario.getNombres());
            stmt.setString(3, usuario.getApellidos());
            stmt.setString(4, usuario.getRol());
            stmt.setString(5, usuario.getCiudad());
            stmt.setString(6, usuario.getDireccion());
            stmt.setString(7, usuario.getEmail());
            stmt.setString(8, usuario.getTelefono());
            stmt.setString(9, usuario.getClave());
            stmt.executeUpdate();
            System.out.println("Usuario insertado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar usuario: " + e.getMessage());
        }
    }

    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombres(rs.getString("nombres"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setRol(rs.getString("rol"));
                usuario.setCiudad(rs.getString("ciudad"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setEmail(rs.getString("email"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setClave(rs.getString("clave"));
                lista.add(usuario);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar usuarios: " + e.getMessage());
        }
        return lista;
    }

    public void actualizar(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombres=?, apellidos=?, rol=?, ciudad=?, direccion=?, email=?, telefono=?, clave=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombres());
            stmt.setString(2, usuario.getApellidos());
            stmt.setString(3, usuario.getRol());
            stmt.setString(4, usuario.getCiudad());
            stmt.setString(5, usuario.getDireccion());
            stmt.setString(6, usuario.getEmail());
            stmt.setString(7, usuario.getTelefono());
            stmt.setString(8, usuario.getClave());
            stmt.setInt(9, usuario.getId());
            stmt.executeUpdate();
            System.out.println("Usuario actualizado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar usuario: " + e.getMessage());
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM usuarios WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Usuario eliminado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al eliminar usuario: " + e.getMessage());
        }
    }
}
