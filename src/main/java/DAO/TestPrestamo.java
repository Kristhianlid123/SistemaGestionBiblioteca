/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Date;

public class TestPrestamo {

    public static void main(String[] args) {

        PrestamoDAO dao = new PrestamoDAO();

        //dao.guardarPrestamo(1,1,Date.valueOf("2026-07-02"),Date.valueOf("2026-07-09"),"Prestado");
        //dao.consultarPrestamoLimite(10);
        dao.buscarPrestamo(8);
    }

}