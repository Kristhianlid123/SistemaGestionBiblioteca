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
        dao.consultarUsuario();
    }
}
