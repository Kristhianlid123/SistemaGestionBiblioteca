/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Usuario
 */
public class TestLibro {
    
    public static void main(String[] args) {
        LibroDAO dao = new LibroDAO();
        
        //dao.guardarLibro("Cien años de soledad", "Gabriel García Márquez", "Disponible");
        //dao.consultarLibroLimite(10);
        //dao.buscarLibro("da");
        dao.eliminarLibro(2);
    }
    
}
