package com.mycompany.consultoriomedico.models;

/**
 * @author Boros
 */
public class Paciente {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private int id;

    public Paciente(String nombre, String apellido, String telefono, String email, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.id = id;
    }

    public Paciente(String nombre, String apellido, String email, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }

    public Paciente(int id) {
        this.id = id;
    }

    public Paciente() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombreCompleto(){
        return this.apellido + ", " + this.nombre;
    }
    
    
}
