package com.qac.software.principal;

import com.qac.software.dao.UsuarioDAO;
import com.qac.software.modelo.Usuario;

import java.util.List;

public class MainUsuarios {
    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();

        // Insertar
        Usuario nuevo = new Usuario(1, "MARIA", "ZORRIA", "Consultor", "Bogotá", "Cll 123", "maria@gmail.com", "1234567", "clave123");
        dao.insertar(nuevo);

        // Listar
        List<Usuario> usuarios = dao.listar();
        for (Usuario u : usuarios) {
            System.out.println(u.getId() + " - " + u.getNombres() + " " + u.getApellidos());
        }

        // Actualizar
        nuevo.setCiudad("Medellín");
        dao.actualizar(nuevo);

        // Eliminar (opcional)
        // dao.eliminar(1);
    }
}
