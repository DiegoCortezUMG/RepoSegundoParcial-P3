/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.clsCliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoCliente {

    private static final String SQL_SELECT = "SELECT aplid, aplnombre, aplestatus FROM tbl_aplicacion";
    private static final String SQL_INSERT = "INSERT INTO tbl_aplicacion(aplnombre, aplestatus) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_aplicacion SET aplnombre=?, aplestatus=? WHERE aplid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_aplicacion WHERE aplid=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT aplid, aplnombre, aplestatus FROM tbl_aplicacion WHERE aplnombre = ?";
    private static final String SQL_SELECT_ID = "SELECT aplid, aplnombre, aplestatus FROM tbl_aplicacion WHERE aplid = ?";    

    public List<clsCliente> consultaCliente() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsCliente> clientes = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("clId");
                String fecha = rs.getString("clFecha");
                String nombre = rs.getString("clNombre");
                String nit = rs.getString("clNit");
                int debe = rs.getInt("clDebe");
                int haber = rs.getInt("clHaber");
                
                clsCliente cliente = new clsCliente();
                cliente.setIdCliente(id);
                cliente.setFechaCliente(fecha);
                cliente.setNombreCliente(nombre);
                cliente.setNitCliente(nit);
                cliente.setDebeCliente(debe);
                cliente.setHaberCliente(haber);
                
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return clientes;
    }

    public int ingresaCliente(clsCliente aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, aplicacion.getFechaCliente());
            stmt.setString(2, aplicacion.getNombreCliente());
            stmt.setString(3, aplicacion.getNitCliente());
            stmt.setInt(4, aplicacion.getDebeCliente());
            stmt.setInt(5, aplicacion.getHaberCliente());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    public int actualizaCliente(clsCliente aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, aplicacion.getFechaCliente());
            stmt.setString(2, aplicacion.getNombreCliente());
            stmt.setString(3, aplicacion.getNitCliente());
            stmt.setInt(4, aplicacion.getDebeCliente());
            stmt.setInt(5, aplicacion.getHaberCliente());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int borrarCliente(clsCliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cliente.getIdCliente());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public clsCliente consultaClientePorNombre(clsCliente aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + aplicacion);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, aplicacion.getIdAplicacion());            
            stmt.setString(1, aplicacion.getNombreCliente());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("clId");
                String fecha = rs.getString("clFecha");
                String nombre = rs.getString("clNombre");
                String nit = rs.getString("clNit");
                int debe = rs.getInt("clDebe");
                int haber = rs.getInt("clHaber");
                
                clsCliente cliente = new clsCliente();
                cliente.setIdCliente(id);
                cliente.setFechaCliente(fecha);
                cliente.setNombreCliente(nombre);
                cliente.setNitCliente(nit);
                cliente.setDebeCliente(debe);
                cliente.setHaberCliente(haber);
                System.out.println(" registro consultado: " + aplicacion);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return aplicacion;
    }
    public clsCliente consultaClientePorId(clsCliente aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + aplicacion);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, aplicacion.getIdCliente());            
            //stmt.setString(1, aplicacion.getNombreAplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("clId");
                String fecha = rs.getString("clFecha");
                String nombre = rs.getString("clNombre");
                String nit = rs.getString("clNit");
                int debe = rs.getInt("clDebe");
                int haber = rs.getInt("clHaber");
                
                clsCliente cliente = new clsCliente();
                cliente.setIdCliente(id);
                cliente.setFechaCliente(fecha);
                cliente.setNombreCliente(nombre);
                cliente.setNitCliente(nit);
                cliente.setDebeCliente(debe);
                cliente.setHaberCliente(haber);
                System.out.println(" registro consultado: " + aplicacion);                
            }   
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return aplicacion;
    }    
}
