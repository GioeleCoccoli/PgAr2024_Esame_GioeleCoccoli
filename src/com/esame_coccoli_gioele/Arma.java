package com.esame_coccoli_gioele;

abstract public class Arma 
{
    private String nome;
    private int range;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getRange() {
        return range;
    }
    public void setRange(int range) {
        this.range = range;
    }
    
}
