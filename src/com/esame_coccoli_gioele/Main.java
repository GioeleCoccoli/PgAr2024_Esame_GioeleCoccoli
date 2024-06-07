package com.esame_coccoli_gioele;

public class Main {
    public static void main(String[] args) 
    {
        /* 
        //Persona prova= new Fuorilegge();
        Mazzo m= new Mazzo();
        //System.out.println(prova.getRuolo());
        System.out.println(m.getMazzo().size());
        int size=m.getMazzo().size();
        int cont=0;
        Carta c;
        do{
            cont++;
            m.pescaCarta();

        }while(m.getMazzo().size()!=0);
        //m.showMazzo();

        System.out.println(cont);
        //Carta c= new Bang();
        //System.out.println(c.getTipo());
        */

        Gestore g= new Gestore();
        g.start();
    }
}
