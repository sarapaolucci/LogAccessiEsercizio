/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logaccessi;

/**
 *
 * @author paolucci.sara
 */
public class AccessiPerUtente {
    private String nome;
    private int numAccessifalliti;
    
    public AccessiPerUtente(String n, int a){
        this.nome = n;
        this.numAccessifalliti = a;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getAccessiFalliti(){
        return this.numAccessifalliti;
    }
    
}
