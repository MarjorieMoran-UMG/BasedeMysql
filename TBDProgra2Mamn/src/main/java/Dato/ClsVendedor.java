/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dato;

import DominioVendedor.ClsVendedorDominio;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Marjorie
 */
public class ClsVendedor {

    private static final String SQL_SELECT = "SELECT * FROM dbt1progra2mamn.tb_vendedores;";
    private static final String SQL_UPDATE = "UPDATE tb_vendedores SET NombreVendedor=?,VentasEnero=?,VentasFebrero=?,VentasMarzo=? WHERE CodigoVendedor=?";
    private static final String SQL_INSERT = "INSERT into tb_vendedores (NombreVendedor, VentasEnero, VentasFebrero, VentasMarzo) VALUES (?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM tb_vendedores WHERE CodigoVendedor = ?";

    public List<ClsVendedorDominio> Seleccionar() {
        Connection conexion = null;
        PreparedStatement stmt = null;
        ResultSet Rset = null;
        ClsVendedorDominio v = null;
        List<ClsVendedorDominio> Ventas = new ArrayList<ClsVendedorDominio>();
        try {
            conexion = ClsConectar.getConnection();
            stmt = conexion.prepareStatement(SQL_SELECT);
            Rset = stmt.executeQuery();
            while (Rset.next()) {
                int codigo = Rset.getInt("CodigoVendedor");
                String nombre = Rset.getString("NombreVendedor");
                int enero = Rset.getInt("VentasEnero");
                int febrero = Rset.getInt("VentasFebrero");
                int marzo = Rset.getInt("VentasMarzo");
                v = new ClsVendedorDominio();
                v.setCodigoVendedor(codigo);
                v.setNombreVendedor(nombre);
                v.setVentasEnero(enero);
                v.setVentasFebrero(febrero);
                v.setVentasMarzo(marzo);
                Ventas.add(v);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ClsConectar.close(Rset);
            ClsConectar.close(stmt);
            ClsConectar.close(conexion);
        }
        return Ventas;
    }

    public int Insertar(ClsVendedorDominio vendedor) {
        Connection Conx = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            Conx = ClsConectar.getConnection();
            stmt = Conx.prepareStatement(SQL_INSERT);
            stmt.setString(1, vendedor.getNombreVendedor());
            stmt.setInt(2, vendedor.getVentasEnero());
            stmt.setInt(3, vendedor.getVentasFebrero());
            stmt.setInt(4, vendedor.getVentasMarzo());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ClsConectar.close(stmt);
            ClsConectar.close(Conx);
        }

        return rows;
    }

    public int Actualizar(ClsVendedorDominio vendedor) {
        Connection Conex = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            Conex = ClsConectar.getConnection();
            stmt = Conex.prepareStatement(SQL_UPDATE);
            stmt.setString(1, vendedor.getNombreVendedor());
            stmt.setInt(2, vendedor.getVentasEnero());
            stmt.setInt(3, vendedor.getVentasFebrero());
            stmt.setInt(4, vendedor.getVentasMarzo());
            stmt.setInt(5, vendedor.getCodigoVendedor());

            System.out.println("Ejecutando query:..." + SQL_UPDATE);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:..." + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ClsConectar.close(stmt);
            ClsConectar.close(Conex);
        }

        return rows;
    }

    public int Eliminar(ClsVendedorDominio vendedor) {
        Connection Conexx = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            Conexx = ClsConectar.getConnection();
            stmt = Conexx.prepareStatement(SQL_DELETE);
            stmt.setInt(1, vendedor.getCodigoVendedor());

            System.out.println("ejecutando query:" + SQL_DELETE);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ClsConectar.close(stmt);
            ClsConectar.close(Conexx);
        }

        return rows;
    }

}
