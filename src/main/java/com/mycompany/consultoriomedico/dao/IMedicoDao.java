package com.mycompany.consultoriomedico.dao;

import com.mycompany.consultoriomedico.models.Medico;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Boros
 */
public interface IMedicoDao {
    public List<Medico> select() throws SQLException;
    
    public int insert(Medico medico) throws SQLException;
    
    public int update(Medico medico) throws SQLException;
    
    public int delete(Medico medico) throws SQLException;
}
