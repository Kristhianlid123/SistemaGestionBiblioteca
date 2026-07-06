/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

public class TestLectores {

    public static void main(String[] args) {

        LectoresDAO dao = new LectoresDAO();

        //dao.guardarLector("Juan Pérez","3001234567","juan@gmail.com");
        
        //dao.consultarLectorLimite(10);
        //dao.buscarLector("ja");
        //dao.eliminarLector(18);
        dao.actualizarLector(2,"Juan Mendez","3001112233","juanM@email.com");
    }

}