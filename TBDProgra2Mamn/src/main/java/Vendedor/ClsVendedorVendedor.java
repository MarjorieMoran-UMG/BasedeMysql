/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vendedor;

import Dato.ClsVendedor;
import DominioVendedor.ClsVendedorDominio;
import java.sql.*;
import java.util.*;


/**
 *
 * @author Marjorie
 */
public class ClsVendedorVendedor {
       public void Seleccionar() {
        String url = "jdbc:mysql://localhost:3306/dbt1progra2mamn?zeroDateTimeBehavior=CONVERT_TO_NULL";
        try {
            Connection conexion = DriverManager.getConnection(url, "root", "");
            Statement sentencia = conexion.createStatement();
            String sql = "SELECT * FROM dbt1progra2mamn.tb_vendedores;";
            ResultSet resultado = sentencia.executeQuery(sql);
            while (resultado.next()) {
                System.out.println("Codigo Vendedor = " + resultado.getInt("CodigoVendedor"));
                System.out.println("Nombre Vendedor = " + resultado.getString("NombreVendedor"));
                System.out.println("Ventas Enero = " + resultado.getInt("VentasEnero"));
                System.out.println("Ventas Febrero = " + resultado.getInt("VentasFebrero"));
                System.out.println("Ventas Marzo = " + resultado.getInt("VentasMarzo"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public void Insertar() {
        ClsVendedor v = new ClsVendedor();
        ClsVendedorDominio vs = new ClsVendedorDominio();
        Scanner t = new Scanner(System.in);
        System.out.println("Ingrese el Nombre del Vendedor:");
        String NombreVendedor = t.nextLine();
        System.out.println("Ingrese las ventas de Enero:");
        int VentaEnero = t.nextInt();
        System.out.println("Ingrese las ventas de Febrero:");
        int VentaFebrero = t.nextInt();
        System.out.println("Ingrese las ventas de Marzo:");
        int VentaMarzo = t.nextInt();
        vs.setNombreVendedor(NombreVendedor);
        vs.setVentasEnero(VentaEnero);
        vs.setVentasFebrero(VentaFebrero);
        vs.setVentasMarzo(VentaMarzo);
        v.Insertar(vs);

        List<ClsVendedorDominio> todos = v.Seleccionar();

        for (ClsVendedorDominio Vendedor : todos) {
            System.out.println("Vendedor = " + Vendedor);
        }
    }

    public void Actualizar() {
        ClsVendedor Vendedorr = new ClsVendedor();
        ClsVendedorDominio CantVende = new ClsVendedorDominio();
        Scanner Scan = new Scanner(System.in);

        System.out.println("Ingrese el Nombre del Vendedor:");
        String NombreV = Scan.nextLine();

        System.out.println("Ingrese las ventas de Enero:");
        int Enero = Scan.nextInt();

        System.out.println("Ingrese las ventas de Febrero:");
        int Febrero = Scan.nextInt();

        System.out.println("Ingrese las ventas de Marzo:");
        int Marzo = Scan.nextInt();

        System.out.println("Ingrese el Codigo del Vendedor:");
        int Codigo = Scan.nextInt();

        CantVende.setNombreVendedor(NombreV);
        CantVende.setVentasEnero(Enero);
        CantVende.setVentasFebrero(Febrero);
        CantVende.setVentasMarzo(Marzo);
        CantVende.setCodigoVendedor(Codigo);
        Vendedorr.Actualizar(CantVende);

        List<ClsVendedorDominio> todos = Vendedorr.Seleccionar();

        for (ClsVendedorDominio Vendedor : todos) {
            System.out.println("Vendedor = " + Vendedor);
        }
    }

    public void Borrar() {
        ClsVendedor Vendedor = new ClsVendedor();
        ClsVendedorDominio CantVende = new ClsVendedorDominio();
        Scanner Scanr = new Scanner(System.in);

        System.out.println("Ingrese el Codigo de Vendedor que desea Eliminar:");
        int Codigo = Scanr.nextInt();

        CantVende.setCodigoVendedor(Codigo);
        Vendedor.Eliminar(CantVende);

        List<ClsVendedorDominio> todos = Vendedor.Seleccionar();

        for (ClsVendedorDominio Vendedorrr : todos) {
            System.out.println("Vendedor = " + Vendedorrr);
        }
    }

    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        ClsVendedorVendedor opcion = new ClsVendedorVendedor();
        String opc = "";
        do {
            System.out.println("---------MENU---------");
            System.out.println("1--- Ver la Tabla");
            System.out.println("2--- Insetar Datos a Tabla");
            System.out.println("3--- Actualizar Datos de Tabla");
            System.out.println("4--- Borrar Datos de Tabla");
            System.out.println("0--- Salir");
            opc = t.nextLine();
            switch (opc) {
                case "1":
                    opcion.Seleccionar();
                    break;
                case "2":
                    opcion.Insertar();
                    break;
                case "3":
                    opcion.Actualizar();
                    break;
                case "4":
                    opcion.Borrar();
                    break;

            }
        } while (!opc.equals("0"));

    }

}
