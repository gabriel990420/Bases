/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.ConnectBD;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author david
 */
public class Mascota {

    private int idMascota;
    private String nombreM;
    private String fechaRegistro;
    private int edad;
    private String RH;
    private String descripcion;
    private String imagen;
    private int idD;
    private int idR;

    public Mascota() {
    }

    public Mascota(String nombreM, String fechaRegistro, int edad, String RH, String descripcion, String imagen, int idD, int idR) {

        this.nombreM = nombreM;
        this.fechaRegistro = fechaRegistro;
        this.edad = edad;
        this.RH = RH;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.idD = idD;
        this.idR = idR;
    }

    public Mascota(int idMascota, String nombreM, String fechaRegistro, int edad, String RH, String descripcion, String imagen, int idD, int idR) {
        this.idMascota = idMascota;
        this.nombreM = nombreM;
        this.fechaRegistro = fechaRegistro;
        this.edad = edad;
        this.RH = RH;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.idD = idD;
        this.idR = idR;
    }
    
    

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombreM() {
        return nombreM;
    }

    public void setNombreM(String nombreM) {
        this.nombreM = nombreM;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRH() {
        return RH;
    }

    public void setRH(String RH) {
        this.RH = RH;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdD() {
        return idD;
    }

    public void setIdD(int idD) {
        this.idD = idD;
    }

    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Mascota{" + "idMascota=" + idMascota + ", nombreM=" + nombreM + ", fechaRegistro=" + fechaRegistro + ", edad=" + edad + ", RH=" + RH + ", descripcion=" + descripcion + ", idD=" + idD + ", idR=" + idR + '}';
    }


    public boolean insertarMascota(String sql) {
        boolean d = false;
        FileInputStream fis = null;
        PreparedStatement ps = null;
        ConnectBD objCB = new ConnectBD();
        try {
            if (objCB.crearConexion()) {
                objCB.getConexion().setAutoCommit(false);
                File file = new File(this.getImagen());
                fis = new FileInputStream(file);
                ps = objCB.getConexion().prepareStatement(sql);
                ps.setString(1, nombreM);
                ps.setString(2, fechaRegistro);
                ps.setString(3, Integer.toString(edad));
                ps.setString(4, RH);
                ps.setString(5, descripcion);
                ps.setBinaryStream(6, fis, (int) file.length());
                ps.setString(7, Integer.toString(idD));
                ps.setString(8, Integer.toString(idR));
                ps.executeUpdate();
                objCB.getConexion().commit();
                d = true;
            }

            try {
                fis.close();
                ps.close();
            } catch (IOException | SQLException e) {
                System.out.println("Error: " + e.toString());
            }

        } catch (SQLException | FileNotFoundException e) {
            System.out.println("Error:" + e);
        }

        return d;

    }

    public ResultSet obtenerMascota(String sql) {
        ResultSet rs = null;

        try {
            ConnectBD objCB = new ConnectBD();

            if (objCB.crearConexion()) {
                rs = objCB.getStatement().executeQuery(sql);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return rs;
    }

    public boolean eliminarMascota(String sql) {
        
        boolean b = false;
        try{
            ConnectBD objCB = new ConnectBD();
            if(objCB.crearConexion()){
                objCB.getStatement().executeUpdate(sql);
                b = true;
            }
        }catch(Exception e){
            System.out.println("Error: "+e.toString());
        }
        
        return b;
    }

    public boolean actualizarMascota(String sql) {
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

}
