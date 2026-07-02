/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.mycompany.proyecto.ConexionMysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LectoresDAO {

    public void guardarLector(String nombre, String telefono, String correo) {

        String consulta = "INSERT INTO lectores(nombre,telefono,correo) VALUES (?,?,?)";

        try {

            ConexionMysql conexion = new ConexionMysql();

            Connection cn = conexion.establecerConexion();

            PreparedStatement ps = cn.prepareStatement(consulta);

            ps.setString(1, nombre);
            ps.setString(2, telefono);
            ps.setString(3, correo);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Registro agregado: " + nombre);
            } else {
                System.out.println("No se guardó ningún registro");
            }

            ps.close();
            cn.close();

        } catch (SQLException e) {

            System.out.println("ERROR al guardar: " + e.getMessage());

        }

    }

}
