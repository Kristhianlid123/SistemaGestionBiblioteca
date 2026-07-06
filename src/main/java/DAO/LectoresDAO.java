/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.mycompany.proyecto.ConexionMysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public void consultarLectorLimite(int limite) {

        String consulta = "SELECT * FROM lectores ORDER BY id_lector DESC LIMIT ?";

        try {

            ConexionMysql conexion = new ConexionMysql();
            Connection cn = conexion.establecerConexion();
            PreparedStatement ps = cn.prepareStatement(consulta);

            ps.setInt(1, limite);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id_lector");
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");

                System.out.println("Datos: " + id + " - " + nombre + " - " + telefono + " - " + correo);

            }

            rs.close();
            ps.close();
            cn.close();

        } catch (SQLException e) {

            System.out.println("ERROR: " + e.getMessage());

        }

    }
    
    public void buscarLector(String nombre) {

        String consulta = "SELECT * FROM lectores WHERE nombre LIKE ?";

        try {

            ConexionMysql conexion = new ConexionMysql();
            Connection cn = conexion.establecerConexion();
            PreparedStatement ps = cn.prepareStatement(consulta);

            ps.setString(1, "%" + nombre + "%");

            ResultSet rs = ps.executeQuery();

            boolean encontrado = false;

            while (rs.next()) {

                int idLector = rs.getInt("id_lector");
                String nombres = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");

                encontrado = true;

                System.out.println(idLector + " - " + nombres + " - " + telefono + " - " + correo);

            }

            if (!encontrado) {

                System.out.println("Registro no encontrado");

            }

            rs.close();
            ps.close();
            cn.close();

        } catch (SQLException e) {

            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();

        }

    }
    
    public void eliminarLector(int id) {

        String consulta = "DELETE FROM lectores WHERE id_lector = ?";

        try {

            ConexionMysql conexion = new ConexionMysql();
            Connection cn = conexion.establecerConexion();
            PreparedStatement ps = cn.prepareStatement(consulta);

            ps.setInt(1, id);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {

                System.out.println("Registro eliminado: " + id);

            } else {

                System.out.println("No se encontró el registro");

            }

            ps.close();
            cn.close();

        } catch (SQLException e) {

            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();

        }

    }

}
