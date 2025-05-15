package com.qac.software.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class HallazgoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tipo = request.getParameter("tipo");
        String proceso = request.getParameter("proceso");
        String descripcion = request.getParameter("descripcion");
        String estado = request.getParameter("estado");
        String fechaHallazgo = request.getParameter("fechaHallazgo");
        String fechaCierre = request.getParameter("fechaCierre");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/qacdb", "root", "");

            String sql = "INSERT INTO hallazgos (tipo, proceso, descripcion, estado, fecha_hallazgo, fecha_cierre) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, tipo);
            stmt.setString(2, proceso);
            stmt.setString(3, descripcion);
            stmt.setString(4, estado);
            stmt.setString(5, fechaHallazgo);
            stmt.setString(6, fechaCierre);

            stmt.executeUpdate();
            conn.close();

            request.setAttribute("tipo", tipo);
            request.setAttribute("proceso", proceso);
            request.setAttribute("descripcion", descripcion);
            request.setAttribute("estado", estado);
            request.setAttribute("fechaHallazgo", fechaHallazgo);
            request.setAttribute("fechaCierre", fechaCierre);
            request.getRequestDispatcher("jsp/hallazgoRegistrado.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error al registrar hallazgo.");
        }
    }
}
