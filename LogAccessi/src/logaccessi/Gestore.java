/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logaccessi;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author paolucci.sara
 */
public class Gestore {
    private FileManager f;
    private ArrayList<Utente> utenti;
    private ArrayList<AccessiPerUtente> accessiPerUtenteFalliti;
    private ArrayList<AccessiPerUtente> accessiFailConsecutivi;
    
    
    public Gestore(String csvFile) throws IOException, FileNotFoundException, ParseException{
        
        this.utenti = new ArrayList();
        this.accessiPerUtenteFalliti = new ArrayList();
        this.accessiFailConsecutivi = new ArrayList();
        this.f = new FileManager(csvFile);
    }
    
    public void leggiF() throws IOException, FileNotFoundException, ParseException{
        f.leggiFile(utenti);
    }
    
    public void contaAccessiFallitiPerUtente(){
        ArrayList<String> nomi = new ArrayList();
        for(int i = 0; i < utenti.size();i++){
            String nome = utenti.get(i).getNome();
            int count = 0;
            for(int j = 0; j < utenti.size();j++){
                if(utenti.get(j).getNome().equals(nome)&& utenti.get(j).getAccesso()== false){
                    count++;
                }
            }
            if(!nomi.contains(nome)){
                AccessiPerUtente a = new AccessiPerUtente(nome,count);
                accessiPerUtenteFalliti.add(a);
            }
            nomi.add(nome);
            count = 0;
        }
        for(int i = 0; i < accessiPerUtenteFalliti.size();i++){
            System.out.println("Lo studente " + accessiPerUtenteFalliti.get(i).getNome() + " ha fallito " + accessiPerUtenteFalliti.get(i).getAccessiFalliti() + " accessi");
        }
        System.out.println();
    }
    
    public void stampaElenco(ArrayList<Utente>u){
        for(Utente ut: u){
            System.out.println(ut.ToString());
        }
    }
    
    public void ordinaLog(){
        ArrayList<Utente> ordinamento = utenti;
        ordinamento.sort(Comparator.comparing(Utente::getAccesso));
        stampaElenco(ordinamento);
        System.out.println();
    }
    
    public void contaIPSospetti(){
        for(int i = 0; i < accessiFailConsecutivi.size();i++){
            System.out.println("L'indirizzo IP " + accessiFailConsecutivi.get(i).getNome() + " è sospetto perchè ha fatto " + accessiFailConsecutivi.get(i).getAccessiFalliti() + " accessi falliti consecutivi");
        }
    }
    
    public void IPDiversiStessoTempo(){
        ArrayList<String> ut = new ArrayList();
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime inizio = LocalDateTime.parse("2026-01-10 08:48", formatter);
        LocalDateTime fine = LocalDateTime.parse("2026-01-10 08:55", formatter);
        for(int i = 0; i < utenti.size();i++){
            if(utenti.get(i).getData().isBefore(fine)&& utenti.get(i).getData().isAfter(inizio)){
                if(!ut.contains(utenti.get(i).getIP())){
                    ut.add(utenti.get(i).getIP());
                }  
            }
        }
        System.out.println("Gli IP diversi in questo intervallo di tempo sono: ");
        for(int i = 0; i < ut.size();i++){
            System.out.println(ut.get(i));
        }
        System.out.println();
    }
    
    public void accCons(){
        String ipCorrente = "";
        int failConsecutivi = 0;
        for (Utente u : utenti) {
            String ip = u.getIP();
            boolean accesso = u.getAccesso();
            if (!ip.equals(ipCorrente)) {
                ipCorrente = ip;
                failConsecutivi = 0;
            }
            if (accesso == false){
                failConsecutivi++;
                if (failConsecutivi == 3){
                    AccessiPerUtente a = new AccessiPerUtente(ip, failConsecutivi);
                    accessiFailConsecutivi.add(a);
                    System.out.println("IP sospetto: " + ip + " - FAIL consecutivi: " + failConsecutivi);
                }
            } 
            else{
                failConsecutivi = 0;
            }
        }
    }
    
}