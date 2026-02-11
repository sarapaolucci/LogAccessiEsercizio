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
    private ArrayList<AccessiPerUtente> accessiFailConsecutivi;
    
    public Gestore(String csvFile){
        this.f = new FileManager(csvFile);
        this.utenti = new ArrayList();
        this.accessiPerUtenteFalliti = new ArrayList();
        this.accessiFailConsecutivi = new ArrayList();
    }
    
    public void controllo(){
        ArrayList<String> nomi = new ArrayList();
        for(int i = 0; i < utenti.size();i++){
            String nome = utenti.get(i).getNome();
            int count = 0;
            int failConsecutivi = 0;
            for(int j = 0; i < utenti.size();i++){
                if(utenti.get(i).getNome().equals(nome)&& utenti.get(i).getAccesso()== false){
                    count++;
                    failConsecutivi++;
                }
                else{
                    failConsecutivi--;
                }
            }
            if (failConsecutivi >2){
                AccessiPerUtente a1 = new AccessiPerUtente(utenti.get(i).getIP(), failConsecutivi);
                accessiFailConsecutivi.add(a1);
            }
            if(!nomi.contains(nome)){
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
    
    public void contaAccessiFallitiPerUtente(){
        for(int i = 0; i < accessiPerUtenteFalliti.size();i++){
            System.out.println("Lo studente " + accessiPerUtenteFalliti.get(i).getNome() + " ha fallito " + accessiPerUtenteFalliti.get(i).getAccessiFalliti() + " accessi");
        }
    }
    
    public void contaIPSospetti(){
        for(int i = 0; i < accessiFailConsecutivi.size();i++){
            System.out.println("L'indirizzo IP " + accessiFailConsecutivi.get(i).getNome() + " è sospetto perchè ha fatto " + accessiFailConsecutivi.get(i).getAccessiFalliti() + " accessi falliti consecutivi");
        }
    }
    
}