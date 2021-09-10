/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DominioVendedor;

/**
 *
 * @author Marjorie
 */
public class ClsVendedorDominio {

    private int CodigoVendedor;
    private String NombreVendedor;
    private int VentasEnero;
    private int VentasFebrero;
    private int VentasMarzo;

    @Override
    public String toString() {
        return "ClsVendedorDominio{" + "CodigoVendedor=" + CodigoVendedor + ", NombreVendedor=" + NombreVendedor + ", VentaEnero=" + VentasEnero + ", VentaFebrero=" + VentasFebrero + ", VentaMarzo=" + VentasMarzo + '}';
    }

    public int getCodigoVendedor() {
        return CodigoVendedor;
    }

    public void setCodigoVendedor(int CodigoVendedor) {
        this.CodigoVendedor = CodigoVendedor;
    }

    public String getNombreVendedor() {
        return NombreVendedor;
    }

    public void setNombreVendedor(String NombreVendedor) {
        this.NombreVendedor = NombreVendedor;
    }

    public int getVentasEnero() {
        return VentasEnero;
    }

    public void setVentasEnero(int VentasEnero) {
        this.VentasEnero = VentasEnero;
    }

    public int getVentasFebrero() {
        return VentasFebrero;
    }

    public void setVentasFebrero(int VentasFebrero) {
        this.VentasFebrero = VentasFebrero;
    }

    public int getVentasMarzo() {
        return VentasMarzo;
    }

    public void setVentasMarzo(int VentasMarzo) {
        this.VentasMarzo = VentasMarzo;
    }
}
