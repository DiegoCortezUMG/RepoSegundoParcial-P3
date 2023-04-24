/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoCliente;
/**
 *
 * @author visitante
 */
public class clsCliente {
    private int IdCliente;
    private String fechaCliente;
    private String NombreCliente;
    private String NitCliente;
    private int DebeCliente;
    private int HaberCliente;

    public clsCliente(int IdCliente, String fechaCliente, String NombreCliente, String NitCliente, int DebeCliente, int HaberCliente) {
        this.IdCliente = IdCliente;
        this.fechaCliente = fechaCliente;
        this.NombreCliente = NombreCliente;
        this.NitCliente = NitCliente;
        this.DebeCliente = DebeCliente;
        this.HaberCliente = HaberCliente;
    }
    public clsCliente() {
    }
    public clsCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getFechaCliente() {
        return fechaCliente;
    }

    public void setFechaCliente(String fechaCliente) {
        this.fechaCliente = fechaCliente;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String NombreCliente) {
        this.NombreCliente = NombreCliente;
    }

    public String getNitCliente() {
        return NitCliente;
    }

    public void setNitCliente(String NitCliente) {
        this.NitCliente = NitCliente;
    }

    public int getDebeCliente() {
        return DebeCliente;
    }

    public void setDebeCliente(int DebeCliente) {
        this.DebeCliente = DebeCliente;
    }
    public int getHaberCliente() {
        return HaberCliente;
    }
    public void setHaberCliente(int HaberCliente) {
        this.HaberCliente = HaberCliente;
    }    
    
    public clsCliente getBuscarInformacionClientePorNombre(clsCliente cliente)
    {
        daoCliente daoCliente = new daoCliente();
        return daoCliente.consultaClientePorNombre(cliente);
    }
    public clsCliente getBuscarInformacionClientePorId(clsCliente cliente)
    {
        daoCliente daoCliente = new daoCliente();
        return daoCliente.consultaClientePorId(cliente);
    }    
    public List<clsCliente> getListadoClientes()
    {
        daoCliente daoCliente = new daoCliente();
        List<clsCliente> listadoUsuarios = daoCliente.consultaCliente();
        return listadoUsuarios;
    }
    public int setBorrarCliente(clsCliente cliente)
    {
        daoCliente daoCliente = new daoCliente();
        return daoCliente.borrarCliente(cliente);
    }          
    public int setIngresarCliente(clsCliente cliente)
    {
        daoCliente daoCliente = new daoCliente();
        return daoCliente.ingresaCliente(cliente);
    }              
    public int setModificarCliente(clsCliente cliente)
    {
        daoCliente daoCliente = new daoCliente();
        return daoCliente.actualizaCliente(cliente);
    }              
}
