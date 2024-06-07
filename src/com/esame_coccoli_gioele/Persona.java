package com.esame_coccoli_gioele;
abstract public class Persona 
{
    private String ruolo;
    private int Pvita=4;
    private String scopo;
    private int id;

    
    public String getRuolo() {
        return ruolo;
    }
    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }
    public int getPvita() {
        return Pvita;
    }
    public void setPvita(int pvita) {
        Pvita = pvita;
    }
    public String getScopo() {
        return scopo;
    }
    public void setScopo(String scopo) {
        this.scopo = scopo;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
}
