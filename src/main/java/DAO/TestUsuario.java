/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Usuario
 */
public class TestUsuario {
    
    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();
        //dao.guardarUsuario("KristhianM", "12345", "KristhianMontoya", "Admin");
        //dao.consultarUsuario();
        //dao.buscarUsuario("ca");
        //dao.eliminarUsuario(2);
        dao.actualizarUsuario(3,"admin","123456","Jansito","Admin");
    }
}
