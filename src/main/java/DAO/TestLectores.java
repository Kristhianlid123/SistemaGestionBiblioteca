/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

public class TestLectores {

    public static void main(String[] args) {

        LectoresDAO insert = new LectoresDAO();

        insert.guardarLector(
                "Juan Pérez",
                "3001234567",
                "juan@gmail.com"
        );

    }

}