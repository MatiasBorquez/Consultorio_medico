package com.mycompany.consultoriomedico.dao;

import com.mycompany.consultoriomedico.models.Medico;
import java.sql.*;
import java.util.*;
import java.util.List;

/**
 * @author Boros
 */
public class MedicoDao implements IMedicoDao{

    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT id, nombre, apellido, email, telefono, disciplina, matricula FROM medico";
    private static final String SQL_INSERT = "INSERT INTO medico(nombre, apellido, email, telefono, disciplina, matricula) values (?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE medico SET nombre=?, apellido=?, email=?, telefono=?, disciplina = ?, matricula = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM medico WHERE id=?";

    public MedicoDao() {

    }

    public MedicoDao(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }
    
    @Override
    public List<Medico> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Medico medico = null;
        List<Medico> medicos = new ArrayList<Medico>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                String disciplina = rs.getString("disciplina");
                String matricula = rs.getString("matricula");

                medico = new Medico();
                medico.setId(id);
                medico.setNombre(nombre);
                medico.setApellido(apellido);
                medico.setEmail(email);
                medico.setTelefono(telefono);
                medico.setEspecializacion(disciplina);
                medico.setMatricula(matricula);

                medicos.add(medico);
            }
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }

        }

        return medicos;
    }

    @Override
    public int insert(Medico medico) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, medico.getNombre());
            stmt.setString(2, medico.getApellido());
            stmt.setString(3, medico.getEmail());
            stmt.setString(4, medico.getTelefono());
            stmt.setString(5, medico.getEspecializacion());
            stmt.setString(6, medico.getMatricula());

            rows = stmt.executeUpdate();
        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }

        return rows;
    }

    @Override
    public int update(Medico medico) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, medico.getNombre());
            stmt.setString(2, medico.getApellido());
            stmt.setString(3, medico.getEmail());
            stmt.setString(4, medico.getTelefono());
            stmt.setString(5, medico.getEspecializacion());
            stmt.setString(6, medico.getMatricula());
            stmt.setInt(7, medico.getId());

            rows = stmt.executeUpdate();

        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }

        return rows;
    }

    @Override
    public int delete(Medico medico) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, medico.getId());
            rows = stmt.executeUpdate();
        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }

        return rows;
    }
    
}
