/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class ConexionMysql {
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";
    private static final String BD = "biblioteca";
    private static final String IP = "localhost";
    private static final String PUERTO = "3306";
    
    private static final String URL = "jdbc:mysql://" + IP +":" + PUERTO + "/" + BD + "?useSSL=false&serverTimezone=UTC";
    
    private Connection conexion;
    
    public Connection establecerConexion(){
        
        try{
            conexion = DriverManager.getConnection(URL,USUARIO,CONTRASENA);
            
            System.out.println("Conexion Exitosa a MySQL");
            
        }catch(SQLException e){
            System.out.println("ERROR al conectar"+e.getMessage());
        }
        return conexion;
    }
    
    public void cerrarConexion(){
        
        try{
            if(conexion !=null && !conexion.isClosed()){
                conexion.close();
                System.out.println("Conexion cerrada correctamente");
                
            }
        }catch (SQLException e){
            System.out.println("ERROR al cerrar la conexion"+e.getMessage());
        }
    }
            
    
}
