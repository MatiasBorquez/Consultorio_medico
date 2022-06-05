package com.mycompany.consultoriomedico.controllers;

import com.mycompany.consultoriomedico.dao.*;
import com.mycompany.consultoriomedico.models.Paciente;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Boros
 */
public class ControllersPacientes {
    
    
    public List<Paciente> select() throws SQLException{
        Connection conexion = null;
        List<Paciente> pacientes = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {conexion.setAutoCommit(false);}
            IPacienteDao dao = new PacienteDAO(conexion);
            pacientes = dao.select();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
        return pacientes;
    }
    public void insert(Paciente paciente) throws SQLException{
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            IPacienteDao dao = new PacienteDAO(conexion);
            dao.insert(paciente);
            conexion.commit();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
        
    }
    public void delete(Paciente paciente) throws SQLException{
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            IPacienteDao dao = new PacienteDAO(conexion);
            dao.delete(paciente);
            conexion.commit();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }
    public void update(Paciente paciente) throws SQLException{
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            IPacienteDao dao = new PacienteDAO(conexion);
            dao.update(paciente);
            conexion.commit();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }
}
