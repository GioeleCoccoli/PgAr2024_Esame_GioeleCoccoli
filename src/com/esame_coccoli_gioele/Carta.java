package com.esame_coccoli_gioele;

abstract public class Carta 
{
    private String tipo;
    private String effetto;
    private int id;


    public String getEffetto() 
    {
        return effetto;
    }

    public void setEffetto(String effetto) 
    {
        this.effetto = effetto;
    }

    public String getTipo() 
    {
        return tipo;
    }

    public void setTipo(String tipo) 
    {
        this.tipo = tipo;
    }
    
    public int getId()
    {
        return this.id;
    }
    public void setId(int id)
    {
        this.id=id;
    }

    protected abstract Arma getPistola();
    
}
