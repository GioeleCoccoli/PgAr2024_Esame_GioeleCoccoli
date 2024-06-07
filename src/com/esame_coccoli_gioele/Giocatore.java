package com.esame_coccoli_gioele;

import java.util.LinkedList;

public class Giocatore 
{
    private String Nome;
    private int id;
    private int Pvita;//presi poi dal personaggio che capiterà
    private Persona ruolo;
    private boolean stato=true;
    private LinkedList<Carta> mano;// mano di carte 
    private Arma pistola;
    public Sceriffo getRuolo;



    public Giocatore(String nome, int id)
    {
        this.Nome=nome;
        this.mano= new LinkedList<>();
        this.pistola = new Colt45();
        this.id=id;
    }


    public void setPvita(int p)
    {
        this.Pvita=p;
    }
    public LinkedList<Carta> getMano()
    {
        return mano;
    }
    public void showMano()
    {
        int dim = mano.size();
        for(int i=0; i<dim; i++)
        {
            System.out.println((i+1) +")" + mano.get(i).getEffetto());
        }
    }

    public void rimuoviCarta(int i, Mazzo scarto)
    {
        scarto.addCarta(mano.get(i));
        mano.remove(i);
    }
    public void setRuolo(Persona p)
    {
        this.ruolo=p;
        this.Pvita=ruolo.getPvita();
    }

    public void addCarta(Carta c)
    {
        mano.add(c);
    }

    public void setStato()
    {
        this.stato= false;
    }

    public void setPistola(Arma pistola)
    {
        this.pistola=pistola;
    }

    public String getNome() 
    {
        return Nome;
    }
    public int getId() 
    {
        return id;
    }
    public int getPvita() 
    {
        return Pvita;
    }
    public Persona getRuolo() 
    {
        return ruolo;
    }
    public boolean getStato() 
    {
        return stato;
    }
    
    
    public void setMano()
    {
        this.mano.clear();
    }

    

    public Arma getPistola() 
    {
        return pistola;
    }


}
