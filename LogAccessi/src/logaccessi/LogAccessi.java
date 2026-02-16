/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package logaccessi;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

/**
 *
 * @author sarap
 */
public class LogAccessi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ParseException {
        Gestore g = new Gestore("LogAccessi.csv");
        g.leggiF();
        g.ordinaLog();
        g.contaAccessiFallitiPerUtente();
        g.IPDiversiStessoTempo();
        g.accCons();
    }
    
}
