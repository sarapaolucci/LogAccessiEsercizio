/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package logaccessi;

/**
 *
 * @author sarap
 */
public class LogAccessi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Gestore g = new Gestore("LogAccessi.csv");
        g.controllo();
        g.contaAccessiFallitiPerUtente();
        g.contaIPSospetti();
    }
    
}
