package com.mycompany.consultoriomedico.controllers;

import com.mycompany.consultoriomedico.dao.*;
import com.mycompany.consultoriomedico.models.Medico;
import java.sql.*;
import java.util.List;

/**
 * @author Boros
 */
public class ControllersMedicos {
        public List<Medico> select() throws SQLException{
        Connection conexion = null;
        List<Medico> medicos = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {conexion.setAutoCommit(false);}
            IMedicoDao dao = new MedicoDao(conexion);
            medicos = dao.select();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
        return medicos;
    }
    public void insert(Medico medico) throws SQLException{
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            IPacienteDao dao = new PacienteDAO(conexion);
            dao.insert(medico);
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
    public void delete(Medico medico) throws SQLException{
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            IMedicoDao dao = new MedicoDao(conexion);
            dao.delete(medico);
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
    public void update(Medico medico) throws SQLException{
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            IMedicoDao dao = new MedicoDao(conexion);
            dao.update(medico);
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
