package com.mycompany.consultoriomedico.models;

/**
 * @author Boros
 */
public class Medico extends Paciente{
    private String especializacion;
    private String matricula;
    private String dni;

    public Medico() {
    }

    public Medico(String especializacion, String matricula, String dni, String nombre, String apellido, String email, String telefono) {
        super(nombre, apellido, email, telefono);
        this.especializacion = especializacion;
        this.matricula = matricula;
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    
}
