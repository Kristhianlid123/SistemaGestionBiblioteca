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

    public void consultarLibroLimite(int limite) {

        String consulta = "SELECT * FROM libros ORDER BY id_libro DESC LIMIT ?";

        try {

            ConexionMysql conexion = new ConexionMysql();
            Connection cn = conexion.establecerConexion();
            PreparedStatement ps = cn.prepareStatement(consulta);

            ps.setInt(1, limite);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id_libro");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                String estado = rs.getString("estado");

                System.out.println("Datos: " + id + " - " + titulo + " - " + autor + " - " + estado);

            }

            rs.close();
            ps.close();
            cn.close();

        } catch (SQLException e) {

            System.out.println("ERROR: " + e.getMessage());

        }

    }
    
    public void buscarLibro(String titulo) {

        String consulta = "SELECT * FROM libros WHERE titulo LIKE ?";

        try {

            ConexionMysql conexion = new ConexionMysql();
            Connection cn = conexion.establecerConexion();
            PreparedStatement ps = cn.prepareStatement(consulta);

            ps.setString(1, "%" + titulo + "%");

            ResultSet rs = ps.executeQuery();

            boolean encontrado = false;

            while (rs.next()) {

                int idLibro = rs.getInt("id_libro");
                String titulos = rs.getString("titulo");
                String autor = rs.getString("autor");
                String estado = rs.getString("estado");

                encontrado = true;

                System.out.println(idLibro + " - " + titulos + " - " + autor + " - " + estado);

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
    
    public void eliminarLibro(int id) {

        String consulta = "DELETE FROM libros WHERE id_libro = ?";

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
    public void actualizarLibro(int id, String titulo, String autor, String estado) {

        String consulta = "UPDATE libros SET titulo = ?, autor = ?, estado = ? WHERE id_libro = ?";

        try {

            ConexionMysql conexion = new ConexionMysql();
            Connection cn = conexion.establecerConexion();
            PreparedStatement ps = cn.prepareStatement(consulta);

            ps.setString(1, titulo);
            ps.setString(2, autor);
            ps.setString(3, estado);
            ps.setInt(4, id);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {

                System.out.println("Registro actualizado: " + titulo);

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
