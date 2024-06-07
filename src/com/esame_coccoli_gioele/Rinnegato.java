package com.esame_coccoli_gioele;

public class Rinnegato extends Persona 
{
    private int id=3;
    private final String RUOLO="RINNEGATO";
    private final String SCOPO="IL TUO SCOPO E'...";
    public Rinnegato()
    {
        setRuolo(RUOLO);
        setScopo(SCOPO);
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
       
    
}
