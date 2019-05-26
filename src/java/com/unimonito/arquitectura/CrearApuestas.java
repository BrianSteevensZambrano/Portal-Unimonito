/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unimonito.arquitectura;

import com.unimonito.aquitecturabasedatos.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.swing.JOptionPane;

/**
 *
 * @author bzamb
 */
@ManagedBean
@RequestScoped
public class CrearApuestas {

    private String equipo1;
    private String equipo2;
    private double valormin;
    private double valormax;

    public String getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }

    public double getValormin() {
        return valormin;
    }

    public void setValormin(double valormin) {
        this.valormin = valormin;
    }

    public double getValormax() {
        return valormax;
    }

    public void setValormax(double valormax) {
        this.valormax = valormax;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    private String imagen;

    public void insert() throws ClassNotFoundException, SQLException {
        conexion cn = new conexion();
        try {
            Connection con = cn.obtener();
            PreparedStatement consulta;
            consulta = con.prepareStatement("INSERT INTO apuesta(equipo1, equipo2, valaorminimo,valormaximo,imagen)  VALUES(?, ?, ?, ?,?)");
            consulta.setString(1, equipo1);
            consulta.setString(2, equipo1);
            consulta.setDouble(3, valormin);
            consulta.setDouble(4, valormax);
            consulta.setString(5, imagen);
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dao");
            System.out.println("si se realizo");

        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }
}

