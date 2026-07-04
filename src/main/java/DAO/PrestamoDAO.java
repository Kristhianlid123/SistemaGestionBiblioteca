/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.mycompany.proyecto.ConexionMysql;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public void consultarPrestamoLimite(int limite) {

        String consulta = "SELECT * FROM prestamos ORDER BY id_prestamo DESC LIMIT ?";

        try {

            ConexionMysql conexion = new ConexionMysql();
            Connection cn = conexion.establecerConexion();
            PreparedStatement ps = cn.prepareStatement(consulta);

            ps.setInt(1, limite);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int idPrestamo = rs.getInt("id_prestamo");
                int idLector = rs.getInt("id_lector");
                int idLibro = rs.getInt("id_libro");
                Date fechaPrestamo = rs.getDate("fecha_prestamo");
                Date fechaDevolucion = rs.getDate("fecha_devolucion");
                String estado = rs.getString("estado");

                System.out.println("Datos: " + idPrestamo + " - " + idLector + " - " + idLibro + " - " + fechaPrestamo + " - " + fechaDevolucion + " - " + estado);

            }

            rs.close();
            ps.close();
            cn.close();

        } catch (SQLException e) {

            System.out.println("ERROR: " + e.getMessage());

        }

    }
}
