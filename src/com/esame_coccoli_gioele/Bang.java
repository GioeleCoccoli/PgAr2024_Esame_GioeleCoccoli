package com.esame_coccoli_gioele;

public class Bang extends Carta
{
    private final String TIPO="GIOCA E SCARTA";
    private final String EFFETTO="CARTA BANG : SPARA A CHI è NELLA TUA PORTATA";
    public Bang()
    {
        setEffetto(EFFETTO);
        setId(2);
        setTipo(TIPO);
    }
    public Arma getPistola()
    {
        return new Winchester();
    };
}
