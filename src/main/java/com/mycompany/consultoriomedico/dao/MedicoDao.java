package com.mycompany.consultoriomedico.dao;

import com.mycompany.consultoriomedico.models.Medico;
import com.mycompany.consultoriomedico.models.Paciente;
import com.mysql.jdbc.StringUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;

/**
 * @author Boros
 */
public class MedicoDao {
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
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE,null,e);
        }
        return conexion;
    }
    
    
    public ArrayList<Medico> listar(){
        ArrayList<Medico> lista = new ArrayList<>();
        try {
            Connection conexion = conectar();
            String sql = "SELECT * FROM `medico`";
            
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sql);
            while(resultado.next()){
                Medico m = new Medico();
                m.setId(resultado.getString("id"));
                m.setNombre(resultado.getString("nombre"));
                m.setApellido(resultado.getString("apellido"));
                m.setEmail(resultado.getString("email"));
                m.setTelefono(resultado.getString("telefono"));
                m.setMatricula(resultado.getString("matricula"));
                m.setEspecializacion(resultado.getString("disciplina"));
                lista.add(m);
                
            }
        } catch (SQLException e) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE,null,e);
        }
        return lista;
    }
    
    public void agregar(Medico medico){
        try {
            Connection conexion = conectar();
            String sql = "INSERT INTO `medico` (`id`, `nombre`, `apellido`, `email`, `telefono`, `disciplina`, "
                    + "`matricula`) VALUES (NULL, '"+medico.getNombre()+"', '"+medico.getApellido()+"', '"+medico.getEmail()
                    +"', '"+medico.getTelefono()+"', '"+medico.getEspecializacion()+"', '"+medico.getMatricula()+"');";
            Statement statement = conexion.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    
    public void borrar(String id){
        try {
            Connection conexion = conectar();
            String sql = "DELETE FROM medico WHERE `medico`.`id` = "+id+"";
            Statement statement = conexion.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    
    public void actualizar(Medico medico){
        try {
            Connection conexion = conectar();
            String sql = "UPDATE `medico` SET `nombre` = '"+medico.getNombre()+"', `apellido` = '"+medico.getApellido()
                    +"', `email` = '"+medico.getEmail()+"', `telefono` = '"+medico.getTelefono()+"', `disciplina` = '"
                    +medico.getEspecializacion()+"', `matricula` = '"+medico.getMatricula()+"' WHERE `medico`.`id` = "+medico.getId()+";";
            Statement statement = conexion.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    public void guardar(Medico m){
        if(StringUtils.isEmptyOrWhitespaceOnly(m.getId())){
            agregar(m);
        }else{
            actualizar(m);
        }
    }
    
}
