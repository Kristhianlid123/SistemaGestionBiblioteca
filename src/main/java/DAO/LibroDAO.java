/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.mycompany.proyecto.ConexionMysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LibroDAO {

    public void guardarLibro(String titulo, String autor, String estado) {

        String consulta = "INSERT INTO libros(titulo,autor,estado) VALUES (?,?,?)";

        try {

            ConexionMysql conexion = new ConexionMysql();

            Connection cn = conexion.establecerConexion();

            PreparedStatement ps = cn.prepareStatement(consulta);

            ps.setString(1, titulo);
            ps.setString(2, autor);
            ps.setString(3, estado);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Libro agregado: " + titulo);
            } else {
                System.out.println("No se guardó ningún libro");
            }

            ps.close();
            cn.close();

        } catch (SQLException e) {

            System.out.println("ERROR al guardar: " + e.getMessage());

        }

    }

}
