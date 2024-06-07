package com.esame_coccoli_gioele;

public class Equipaggiabile extends Carta 
{
    private final String TIPO="EQUIPAGGIABILE";
    private final String EFFETTO="Puoi equipaggiare questa carta sostutendola all'arma attuale";
    private Arma pistola;

    public Equipaggiabile(Arma pistola)
    {
        this.pistola=pistola;
        setTipo(TIPO);
        setEffetto(pistola.getNome()+ " " + EFFETTO);
        setId(1);
    }

    public Arma getPistola()
    {
        return this.pistola;
    }
}
