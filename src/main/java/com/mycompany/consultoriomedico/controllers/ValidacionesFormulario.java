package com.mycompany.consultoriomedico.controllers;

import com.mycompany.consultoriomedico.models.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Boros
 */
public class ValidacionesFormulario {
    public boolean ValidacionPaciente(Paciente p){
        return !(ValidarNombre(p.getNombre()) || ValidarNombre(p.getApellido()) || ValidarTelefono(p.getTelefono())
                || ValidarEmail(p.getEmail()));
    }
    
    public boolean ValidacionMedico(Medico m){
        return !(ValidarNombre(m.getNombre()) || ValidarNombre(m.getApellido()) || ValidarTelefono(m.getTelefono())
                || ValidarEmail(m.getEmail())|| ValidarEspecializacion(m.getEspecializacion()) ||
                ValidarMatricula(m.getMatricula()));
    }
    
    public boolean ValidarNombre(String nombre){
        
        if(nombre.equals("")){
            JOptionPane.showMessageDialog(null, "El campo de nombre esta vacio");
            return false;
        } 
        return true;
    }
    
    public boolean ValidarApellido(String nombre){
        
        if(nombre.equals("")){
            JOptionPane.showMessageDialog(null, "El campo de apellido esta vacio");
            return false;
        } 
        return true;
    }
    
    public boolean ValidarMatricula(String matricula){
        
        if(matricula.equals("")){
            JOptionPane.showMessageDialog(null, "El campo de matricula esta vacio");
            return false;
        } 
        return true;
    }
    
    public boolean ValidarEspecializacion(String especializacion){
        
        if(especializacion.equals("")){
            JOptionPane.showMessageDialog(null, "El campo de especializacion esta vacio");
            return false;
        } 
        return true;
    }
    
    public boolean ValidarEmail(String email){
        if(email.equals("")){
            JOptionPane.showMessageDialog(null, "El campo de email esta vacio");
            return false;
        }
        if (email.contains("@") && email.contains(".com") ){
            JOptionPane.showMessageDialog(null, "El Email no es valido");
            return false;
        }
        return true;
    }
    
    public boolean ValidarTelefono(String telefono){
        if(telefono.equals("")){
            JOptionPane.showMessageDialog(null, "El campo de telefono esta vacio");
            return false;
        }
        if(telefono.length() < 12 || "+".equals(String.valueOf(telefono.charAt(0)))){
            JOptionPane.showMessageDialog(null, "El telefono es Invalido");
            return false;
        }
        return true;
    }
    
    public boolean ValidarTurno(String turno){
        
        return true;
    }
    
    
}
