package com.qac.software.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class ReclutamientoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idCliente = request.getParameter("idCliente");
        String tipoCargo = request.getParameter("tipoCargo");
        String tipoPlan = request.getParameter("tipoPlan");
        String fechaInicio = request.getParameter("fechaInicio");
        String fechaFin = request.getParameter("fechaFin");
        String reclutador = request.getParameter("reclutador");

        String[] pruebasSeleccionadas = request.getParameterValues("pruebas");
        String pruebas = "";
        if (pruebasSeleccionadas != null) {
            pruebas = String.join(", ", pruebasSeleccionadas);
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/qacdb", "root", "");

            String sql = "INSERT INTO reclutamiento (id_cliente, tipo_cargo, tipo_plan, fecha_inicio, fecha_fin, pruebas, reclutador) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, idCliente);
            stmt.setString(2, tipoCargo);
            stmt.setString(3, tipoPlan);
            stmt.setString(4, fechaInicio);
            stmt.setString(5, fechaFin);
            stmt.setString(6, pruebas);
            stmt.setString(7, reclutador);

            stmt.executeUpdate();
            conn.close();

            request.setAttribute("idCliente", idCliente);
            request.setAttribute("tipoCargo", tipoCargo);
            request.setAttribute("tipoPlan", tipoPlan);
            request.setAttribute("fechaInicio", fechaInicio);
            request.setAttribute("fechaFin", fechaFin);
            request.setAttribute("pruebas", pruebas);
            request.setAttribute("reclutador", reclutador);
            request.getRequestDispatcher("jsp/procesoRegistrado.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error al registrar proceso.");
        }
    }
}
