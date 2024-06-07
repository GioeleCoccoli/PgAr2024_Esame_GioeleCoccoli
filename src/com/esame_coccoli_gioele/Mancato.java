package com.esame_coccoli_gioele;

public class Mancato extends Carta
{
    private final String EFFETTO="CARTA MANCATO: PUOI SCHIVARE UN COLPO DI UN AVVERSARIO";
    private final String TIPO="GIOCA E SCARTA";
    public Mancato()
    {
        setEffetto(EFFETTO);
        setTipo(TIPO);
        setId(3);
    }
    public Arma getPistola()
    {
        return new Winchester();
    };

}
