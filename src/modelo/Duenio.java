/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.ConnectBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author david
 */
public class Duenio {

    private int idDuenio;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String appelido2;
    private String direccion;
    private String correo;

    public Duenio() {
    }

    public Duenio(int idDuenio, String nombre1, String nombre2, String apellido1, String appelido2, String direccion, String correo) {
        this.idDuenio = idDuenio;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.appelido2 = appelido2;
        this.direccion = direccion;
        this.correo = correo;
    }

    
    public Duenio(int idDuenio, String nombre1, String apellido1, String direccion, String correo) {
        this.idDuenio = idDuenio;
        this.nombre1 = nombre1;
        this.apellido1 = apellido1;
        this.direccion = direccion;
        this.correo = correo;
    }

    public Duenio(String nombre1, String nombre2, String apellido1, String appelido2, String direccion, String correo) {

        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.appelido2 = appelido2;
        this.direccion = direccion;
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Duenio{" + "idDuenio=" + idDuenio + ", nombre1=" + nombre1 + ", nombre2=" + nombre2 + ", apellido1=" + apellido1 + ", appelido2=" + appelido2 + ", direccion=" + direccion + ", correo=" + correo + '}';
    }

    public int getIdDuenio() {
        return idDuenio;
    }

    public void setIdDuenio(int idDuenio) {
        this.idDuenio = idDuenio;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getAppelido2() {
        return appelido2;
    }

    public void setAppelido2(String appelido2) {
        this.appelido2 = appelido2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean insertarDuenio(String sql) {

        boolean d = false;
        ConnectBD objCB = new ConnectBD();

        try {
            if (objCB.crearConexion()) {
                Statement sentencia = objCB.getStatement();
                sentencia.executeUpdate(sql);
                d = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.toString());
        }

        return d;
    }

    public ResultSet obtenerDuenio(String sql) {
       ResultSet rs = null;
       
       try{
           ConnectBD objDB = new ConnectBD();
           
           if(objDB.crearConexion()){
               rs = objDB.getStatement().executeQuery(sql);
           }
           
       }catch(Exception e){
           System.out.println("Error: "+e.toString());
       }
       
       return rs;
    }

    public boolean eliminarDuenio(String sql) {
       boolean d = false;
       try{
           ConnectBD objCB = new ConnectBD();
           if(objCB.crearConexion()){
               objCB.getStatement().executeUpdate(sql);
           }
           d = true;
       }catch(Exception e){
           System.out.println("Error: "+e.toString());
       }
       return d;
    }
    
    public boolean ActualizarDuenio(String sql){
        boolean d=false;
       try{
           ConnectBD connectdb= new ConnectBD();
           if(connectdb.crearConexion()){
            connectdb.getStatement().executeUpdate(sql);
           
               
           }
            d=true;
       }catch(Exception e){
           System.out.println("ERROR: "+e);
           
       }
        
        return d;
    }

}
