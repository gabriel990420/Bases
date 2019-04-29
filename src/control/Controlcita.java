/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.ResultSet;
import modelo.Cita;

/**
 *
 * @author david
 */
public class Controlcita {
    public static boolean insertarCita( Cita objC){
        boolean d;
        String sql= "INSERT INTO cita(diagnostico, tratamiento, valorcita, fecha_hora, idV, idMas)"+
                "values(?,?,?,?,?,?)";
        d = objC.insertarCita(sql);
        return d;
    }
    
    public static Cita obtenerCita(int idcita){
        Cita objC = new Cita();
        
        String diagnostico;
        String tratamiento;
        int valor_cita;
        String fecha_hora;
        int idV;
        int idMas;
        
        String sql = "SELECT * FROM cita WHERE idcita=" + Integer.toString(idcita);
        ResultSet rs = objC.obtenerCita(sql);
        
        if(rs==null){
            objC=null;
        }else{
            try{
                rs.next();
                diagnostico = rs.getString("diagnostico");
                tratamiento = rs.getString("tratamiento");
                valor_cita = rs.getInt("valorcita");
                fecha_hora = rs.getString("fecha_hora");
                idV = rs.getInt("idV");
                idMas = rs.getInt("idMas");
                
                objC = new Cita(diagnostico, tratamiento, valor_cita, fecha_hora, idV, idMas);
                objC.setIdCita(idcita);
            }catch(Exception e){
                System.out.println("Error:" + e.toString());
                
            }
        }
        return objC;        
    }
    
    public static boolean eliminarCita(int idCita){
        boolean c;
        Cita objC = new Cita();
        
        String sql = "DELETE FROM cita WHERE idcita ="+ Integer.toString(idCita);
        c=objC.eliminarCita(sql);
        return c;
    }
    
    public static boolean actualizarCine(Cita objC){
        boolean b;
        String idCita, valor_cita;
        String diagnostico, tratamiento, fecha_hora, idV, idMas;
        
        idCita = Integer.toString(objC.getIdCita());
        diagnostico = "'"+objC.getDiagnostico()+"'";
        tratamiento = "'"+objC.getTratamiento()+"'";
        valor_cita = Integer.toString(objC.getValor_cita());
        fecha_hora = "'"+objC.getFecha_hora()+"'";
        idV = Integer.toString(objC.getIdV());
        idMas = Integer.toString(objC.getIdMas());
        
        
        String sql = "update cita set "
                + "diagnostico = "+diagnostico+", tratamiento = "+tratamiento+", valorcita = "+valor_cita+", fecha_hora = "+
                fecha_hora+", idV = "+idV+", idMas = "+idMas+" where idcita = "+idCita;
        b = objC.actualizarCita(sql);
        return b;
    }
}
