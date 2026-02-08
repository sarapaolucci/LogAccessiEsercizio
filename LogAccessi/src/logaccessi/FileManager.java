/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logaccessi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author sarap
 */
public class FileManager {
    private String csvFile;
    
    
    public FileManager(String csv){
        this.csvFile = csv;
    }
    
    public void leggiFile(ArrayList<Utente> accessi) throws FileNotFoundException, IOException, ParseException{
        try(BufferedReader reader = new BufferedReader(new FileReader(csvFile))){
            String line;
            reader.readLine();
            while((line = reader.readLine()) != null){
                String[] colonne = line.split(",");
                DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime dataOra = LocalDateTime.parse(colonne[0], formatter);
                Utente u = new Utente(colonne[1],colonne[2],Boolean.parseBoolean(colonne[3]),dataOra);
                accessi.add(u);
            }
        }
    }
}
