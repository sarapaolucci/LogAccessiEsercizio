/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logaccessi;

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
    
    public Gestore(String csvFile){
        this.f = new FileManager(csvFile);
        this.utenti = new ArrayList();
        this.accessiPerUtenteFalliti = new ArrayList();
    }
    
    public void contaAccessiFallitiPerUtente(){
        ArrayList<String> nomi = new ArrayList();
        for(int i = 0; i < utenti.size();i++){
            String nome = utenti.get(i).getNome();
            int count = 0;
            for(int j = 0; i < utenti.size();i++){
                if(utenti.get(i).getNome().equals(nome)&& utenti.get(i).getAccesso()== false){
                    count++;
                }
            }
            if(!nomi.contains(nome)){
                System.out.println("Gli accessi falliti per " + nome + " sono "+ count);
                AccessiPerUtente a = new AccessiPerUtente(nome,count);
                accessiPerUtenteFalliti.add(a);
            }
            nomi.add(nome);
            count = 0;
        }
    }
    
    public void stampaElenco(ArrayList<Utente>u){
        for(Utente ut: u){
            System.out.println("Username: " + ut.getNome());
        }
    }
    
    public void ordinaLog(){
        ArrayList<Utente> ordinamento = utenti;
        ordinamento.sort(Comparator.comparing(Utente::getAccesso));
        stampaElenco(ordinamento);
    }
    
}
