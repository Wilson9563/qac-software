package com.qac.software.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class AuditoriaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tipo = request.getParameter("tipo");
        String norma = request.getParameter("norma");
        String fechaInicio = request.getParameter("fechaInicio");
        String fechaFin = request.getParameter("fechaFin");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/qacdb", "root", "");

            String sql = "INSERT INTO auditorias (tipo, norma, fecha_inicio, fecha_fin) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, tipo);
            stmt.setString(2, norma);
            stmt.setString(3, fechaInicio);
            stmt.setString(4, fechaFin);

            stmt.executeUpdate();
            conn.close();

            request.setAttribute("tipo", tipo);
            request.setAttribute("norma", norma);
            request.setAttribute("fechaInicio", fechaInicio);
            request.setAttribute("fechaFin", fechaFin);
            request.getRequestDispatcher("jsp/auditoriaRegistrada.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error al registrar auditoría.");
        }
    }
}
