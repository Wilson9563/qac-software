package com.qac.software.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class UsuarioServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String apellidos = request.getParameter("apellidos");
        String nombres = request.getParameter("nombres");
        String rol = request.getParameter("rol");
        String ciudad = request.getParameter("ciudad");
        String direccion = request.getParameter("direccion");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        String contrasena = request.getParameter("contrasena");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/qacdb", "root", "");

            String sql = "INSERT INTO usuarios (id, apellidos, nombres, rol, ciudad, direccion, email, telefono, contrasena) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, id);
            stmt.setString(2, apellidos);
            stmt.setString(3, nombres);
            stmt.setString(4, rol);
            stmt.setString(5, ciudad);
            stmt.setString(6, direccion);
            stmt.setString(7, email);
            stmt.setString(8, telefono);
            stmt.setString(9, contrasena);
            stmt.executeUpdate();

            conn.close();

            request.setAttribute("id", id);
            request.setAttribute("nombres", nombres);
            request.setAttribute("rol", rol);
            request.getRequestDispatcher("jsp/usuarioRegistrado.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error al registrar usuario.");
        }
    }
}
