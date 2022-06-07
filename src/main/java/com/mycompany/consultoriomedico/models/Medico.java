package com.mycompany.consultoriomedico.models;

/**
 * @author Boros
 */
public class Medico extends Paciente{
    private String especializacion;
    private String matricula;

    public Medico() {
    }

    public Medico(int id) {
        super(id);
    }

    public Medico(String especializacion, String matricula, String nombre, String apellido, String telefono, String email, int id) {
        super(nombre, apellido, telefono, email, id);
        this.especializacion = especializacion;
        this.matricula = matricula;
    }

    public Medico(String especializacion, String matricula, String nombre, String apellido, String email, String telefono) {
        super(nombre, apellido, email, telefono);
        this.especializacion = especializacion;
        this.matricula = matricula;
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
