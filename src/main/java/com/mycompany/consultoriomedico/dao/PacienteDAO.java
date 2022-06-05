package com.mycompany.consultoriomedico.dao;

import com.mycompany.consultoriomedico.models.Paciente;
import java.sql.*;
import java.util.*;

/**
 * @author Boros
 */
public class PacienteDAO implements IPacienteDao{

    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT id, nombre, apellido, email, telefono WHERE paciente";
    private static final String SQL_INSERT = "INSERT INTO paciente(nombre, apellido, email, telefono) values (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE paciente SET nombre=?, apellido=?, email=?, telefono=? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM paciente WHERE id=?";

    public PacienteDAO() {

    }

    public PacienteDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }
    
    @Override
    public List<Paciente> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Paciente paciente = null;
        List<Paciente> pacientes = new ArrayList<>();

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

                paciente = new Paciente();
                paciente.setId(id);
                paciente.setNombre(nombre);
                paciente.setApellido(apellido);
                paciente.setEmail(email);
                paciente.setTelefono(telefono);

                pacientes.add(paciente);
            }
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }

        }

        return pacientes;
    }

    @Override
    public int insert(Paciente paciente) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, paciente.getNombre());
            stmt.setString(2, paciente.getApellido());
            stmt.setString(3, paciente.getEmail());
            stmt.setString(4, paciente.getTelefono());

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
    public int update(Paciente paciente) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, paciente.getNombre());
            stmt.setString(2, paciente.getApellido());
            stmt.setString(3, paciente.getEmail());
            stmt.setString(4, paciente.getTelefono());
            stmt.setInt(5, paciente.getId());

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
    public int delete(Paciente paciente) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, paciente.getId());
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
