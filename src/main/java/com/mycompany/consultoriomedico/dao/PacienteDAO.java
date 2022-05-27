package com.mycompany.consultoriomedico.dao;

import com.mycompany.consultoriomedico.models.Paciente;
import com.mysql.jdbc.StringUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;

/**
 * @author Boros
 */
public class PacienteDAO {
    
    public Connection conectar(){
        String baseDatos = "consultorio";
        String usuario = "root";
        String host = "localhost";
        String password = "";
        String puerto = "3306";
        String driver = "com.mysql.jdbc.Driver";
        String conexionUrl = "jdbc:mysql://" + host + ":" + puerto + "/" + baseDatos + "?useSSL=false";
        Connection conexion = null;
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(conexionUrl,usuario,password);
        } catch (Exception e) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE,null,e);
        }
        return conexion;
    }
    
    public ArrayList<Paciente> listar(){
        ArrayList<Paciente> lista = new ArrayList<>();
        try {
            Connection conexion = conectar();
            String sql = "SELECT * FROM `pacientes`";
            
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sql);
            while(resultado.next()){
                Paciente c = new Paciente();
                c.setId(resultado.getString("id"));
                c.setNombre(resultado.getString("nombre"));
                c.setApellido(resultado.getString("apellido"));
                c.setEmail(resultado.getString("email"));
                c.setTelefono(resultado.getString("telefono"));
                lista.add(c);
                
            }
        } catch (Exception e) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE,null,e);
        }
        return lista;
    }
    
    public void agregar(Paciente paciente){
        try {
            Connection conexion = conectar();
            String sql = "INSERT INTO `pacientes` (`id`, `nombre`, `apellido`, `email`, `telefono`) VALUES (NULL, '"+paciente.getNombre()+"', '"+paciente.getApellido()+"', '"+paciente.getEmail()+"', '"+paciente.getTelefono()+"');";
            Statement statement = conexion.createStatement();
            statement.execute(sql);
        } catch (Exception e) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    
    public void borrar(String id){
        try {
            Connection conexion = conectar();
            String sql = "DELETE FROM pacientes WHERE `pacientes`.`id` = " +id+";";
            Statement statement = conexion.createStatement();
            statement.execute(sql);
        } catch (Exception e) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    
    public void actualizar(Paciente paciente){
        try {
            Connection conexion = conectar();
            String sql = "UPDATE `pacientes` SET `nombre` = '"+paciente.getNombre()+"', `apellido` = '"+paciente.getApellido()+"', `email` = '"+paciente.getEmail()+"', `telefono` = '"+paciente.getTelefono()+"' WHERE `pacientes`.`id` = "+paciente.getId()+";";
            Statement statement = conexion.createStatement();
            statement.execute(sql);
        } catch (Exception e) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    public void guardar(Paciente p){
        if(StringUtils.isEmptyOrWhitespaceOnly(p.getId())){
            agregar(p);
        }else{
            actualizar(p);
        }
    }
}
