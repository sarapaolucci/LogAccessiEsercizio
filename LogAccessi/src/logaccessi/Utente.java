/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logaccessi;

import java.time.LocalDateTime;

/**
 *
 * @author sarap
 */
public class Utente {
    private String username, ip;
    private boolean esitoAccesso;
    private LocalDateTime data;
    
    public Utente(String u, String ip, boolean ea, LocalDateTime d){
        this.data = d;
        this.esitoAccesso = ea;
        this.ip = ip;
        this.username = u;
    }
    
    public String getNome(){
        return this.username;
    }
    
    public boolean getAccesso(){
        return esitoAccesso;
    }
    
}
