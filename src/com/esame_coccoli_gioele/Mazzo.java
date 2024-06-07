package com.esame_coccoli_gioele;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Mazzo 
{
    private LinkedList<Carta> carte;
    //int numCarte=80;
    //6 EQUIPAGGIABILI
    //74 Gioca e scarta
    public Mazzo()
    {

        carte= new LinkedList<>();
        generaMazzo();
        mescolaMazzo();
    }
     
    public int getSize()
    {
        return carte.size();
    }
    public void addCarta(Carta c)
    {
        carte.add(c);
    }
    public Carta pescaCarta()
    {
        Carta pescata=carte.getFirst();
        carte.removeFirst();
        return pescata;
        //funzione che ti pesa una carta e la rimuove dal mazzo
    }
        
    public void mescolaMazzo()
    {
        Collections.shuffle(carte); 
    }

    public void generaMazzo()
    {
        for(int i=0;i<50;i++)
        {
            Carta c= new Bang();
            carte.add(c);
        }

        for(int i=0;i<24;i++)
        {
            carte.add(new Mancato());
        }

        for(int i=0;i<3;i++)
        {
            carte.add(new Equipaggiabile(new Schofield()));
        }
         
        carte.add(new Equipaggiabile(new Remington()));
        carte.add(new Equipaggiabile(new Rev_Carabine()));
        carte.add(new Equipaggiabile(new Winchester()));
        
    }

    public LinkedList<Carta> getMazzo()
    {
        return carte;
    }


    public void showMazzo()
    {
        for(int i=0; i<carte.size();i++)
        {
            System.out.println(carte.get(i).getEffetto());
           
        }
    }

}
