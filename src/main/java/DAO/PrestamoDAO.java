/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.mycompany.proyecto.ConexionMysql;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrestamoDAO {

    public void guardarPrestamo(int idLector, int idLibro,
            Date fechaPrestamo, Date fechaDevolucion,
            String estado) {

        String consulta = "INSERT INTO prestamos(id_lector,id_libro,fecha_prestamo,fecha_devolucion,estado) VALUES (?,?,?,?,?)";

        try {

            ConexionMysql conexion = new ConexionMysql();

            Connection cn = conexion.establecerConexion();

            PreparedStatement ps = cn.prepareStatement(consulta);

            ps.setInt(1, idLector);
            ps.setInt(2, idLibro);
            ps.setDate(3, fechaPrestamo);
            ps.setDate(4, fechaDevolucion);
            ps.setString(5, estado);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {

                System.out.println("Préstamo registrado correctamente.");

            } else {

                System.out.println("No se guardó ningún préstamo.");

            }

            ps.close();
            cn.close();

        } catch (SQLException e) {

            System.out.println("ERROR al guardar: " + e.getMessage());

        }

    }

}
