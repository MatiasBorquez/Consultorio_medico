/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.consultoriomedico.dao;

import com.mycompany.consultoriomedico.models.Paciente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Boros
 */
public interface IPacienteDao {
    public List<Paciente> select() throws SQLException;
    
    public int insert(Paciente paciente) throws SQLException;
    
    public int update(Paciente paciente) throws SQLException;
    
    public int delete(Paciente paciente) throws SQLException;
}
