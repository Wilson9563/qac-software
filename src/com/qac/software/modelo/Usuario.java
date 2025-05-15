package com.qac.software.modelo;

public class Usuario {
    private int id;
    private String nombres;
    private String apellidos;
    private String rol;
    private String ciudad;
    private String direccion;
    private String email;
    private String telefono;
    private String clave;

    public Usuario() {
    }

    public Usuario(int id, String nombres, String apellidos, String rol, String ciudad,
                   String direccion, String email, String telefono, String clave) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.rol = rol;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.clave = clave;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
