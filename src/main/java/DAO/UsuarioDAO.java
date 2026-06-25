/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.mycompany.proyecto.ConexionMysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class UsuarioDAO {
    
    public void guardarUsuario(String usuario, String contraseña, String nombre, String rol)
    {
        String consulta = "INSERT INTO usuarios(usuario,contraseña,nombre,rol)VALUES(?,?,?,?)";
        
        try{
            ConexionMysql conexion = new ConexionMysql();
            
            Connection cn = conexion.establecerConexion();
            
            PreparedStatement ps = cn.prepareStatement(consulta);
            
            ps.setString(1, usuario);
            ps.setString(2, contraseña);
            ps.setString(3, nombre);
            ps.setString(4, rol);
            
            int filasAfectadas = ps.executeUpdate();
            
            if(filasAfectadas > 0){
                System.out.println("Registro agregado: "+ nombre);
                
                
            }else{
                System.out.println("No se guardo ningun registro");
            }
            
            ps.close();
            cn.close();
            
        }catch (SQLException e){
            
            System.out.println("ERROR al guardar"+e.getMessage());
        }
    }
    
}
