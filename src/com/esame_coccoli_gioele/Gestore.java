package com.esame_coccoli_gioele;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthLookAndFeel;

public class Gestore 
{
    //ID CARTE: 
    //EQUIPAGGIABILI: 1
    //BANG 2
    //MANCATO 3

    private int numero_giocatori;
    private Integer start=0;
    private Mazzo scarto;
    private LinkedList<Giocatore> giocatori;
    private boolean endgame=false;
    Scanner t= new Scanner (System.in);
    public Gestore()
    {
        
    }

    public void start()
    {
        giocatori = new LinkedList<>();
        numero_giocatori =sceltaNUmeroGiocatori();
        creaGiocatori(numero_giocatori);
        scarto= new Mazzo();
        //mazzo di carte
        Mazzo m = new Mazzo();
        boolean turno=true;
        pescaCarte(numero_giocatori,m);
        do
        {
            //pesca
            if(m.getSize()==1 || m.getSize()==2) 
            {
                for(int i=0; i<m.getSize();i++)
                {
                    System.out.println("pesca " + m.getSize() +" carte: ");
                    Carta c;
                    c=m.pescaCarta();
                    System.out.println(c.getEffetto());
                    giocatori.get(start).addCarta(c);
                }

                for(int i=0;i<scarto.getSize();i++)
                {
                    m.addCarta(scarto.pescaCarta());
                    
                }
                m.mescolaMazzo();
            }
            else
            {
                System.out.println("pesca due carte: ");
                Carta c;
                c=m.pescaCarta();
                System.out.println(c.getEffetto());
                giocatori.get(start).addCarta(c);
                c=m.pescaCarta();
                System.out.println(c.getEffetto());
                System.out.println();
                giocatori.get(start).addCarta(c);
                do
                {

                    turno = menu(giocatori.get(start), m);

                }while(turno);

                scarta(giocatori.get(start));
                //scarta
                start++;
                if(start<giocatori.size())
                {
                    
                } 
                else
                {
                    start=0;
                } 
            }
            


        
        }while(endgame==false);

        System.out.println("PARTITA TERMINATA");

    }


    public void scarta(Giocatore g)
    {
        int scartare=0;
        if(g.getMano().size()>g.getPvita())
        {
            scartare=g.getMano().size()- g.getPvita();
            System.out.println("DEVI SCARTARE " + scartare + " CARTE");
            do
            {

                g.showMano();
                g.rimuoviCarta(t.nextInt()-1, scarto);
                scartare--;

            }while(scartare>0);
        }
    }
    public void creaGiocatori(int n)
    {
        switch(n)
        {
            case 4:
                inserisciNome(n);
                assegnaRuoli(1, 2, 0, 1, n);
                break;
            case 5:
                inserisciNome(n);
                assegnaRuoli(1, 2, 1, 1, n);
                break;
            case 6:
                inserisciNome(n);
                assegnaRuoli(1, 3, 1, 1, n);
                break;
            case 7:
                inserisciNome(n);
                assegnaRuoli(1, 3, 2, 1, n);
                break;
            default: break;


        }

    }

    public void inserisciNome(int n)
    {
        for(int i=0; i<n; i++)
        {
            System.out.println("giocatore " + (i+1) + "inserisci il nome: ");
            String nome = t.next();
            giocatori.add(new Giocatore(nome, i));
        }
    }
    public void assegnaRuoli(int numSceriffo, int numFuoriLegge, int numVice, int numRinnegato, int n)
    {
        int j=0;
        LinkedList<Giocatore> copia= new LinkedList<>(giocatori);
        Random random = new Random();
        int number = random.nextInt(copia.size());

        do{
            if(copia.get(number)!=null)
            {
                giocatori.get(number).setRuolo(new Sceriffo());
                System.out.println(giocatori.get(number).getNome() + " tu sarai lo sceriffo");
                start=number;
                copia.set(number, null);
                j++;
            }
        }while(j<numSceriffo);

        j=0;
        do{
            number = random.nextInt(copia.size());
            if(copia.get(number)!=null)
            {
                giocatori.get(number).setRuolo(new Fuorilegge());
                System.out.println(giocatori.get(number).getNome() + " tu sarai un fuorilegge");
                copia.set(number, null);
                j++;
            }
        }while(j<numFuoriLegge);

        j=0;
        do{
            number = random.nextInt(copia.size());
            if(copia.get(number)!=null)
            {
                giocatori.get(number).setRuolo(new Vice());
                System.out.println(giocatori.get(number).getNome() + " tu sarai un vice");
                copia.set(number, null);
                j++;
            }
        }while(j<numVice);
        j=0;
        do{
            number = random.nextInt(copia.size());
            if(copia.get(number)!=null)
            {
                giocatori.get(number).setRuolo(new Rinnegato());
                System.out.println(giocatori.get(number).getNome() + " tu sarai un rinnegato");
                copia.set(number, null);
                j++;
            }
        }while(j<numRinnegato);

        System.out.println();
    }






    public int sceltaNUmeroGiocatori()
    {
        int scelta=0;
        System.out.println("BENVENUTO, SCEGLI IL NUMERO DI GIOCATORI : DA 4 A 7");
        do
        {
            try
            {
                scelta= t.nextInt();
            }
            catch(Exception e)
            {
                System.out.println("formato errato");
                scelta=sceltaNUmeroGiocatori();
                break;
            };
            
        }while(scelta<4||scelta>7);
        
        return scelta;
    }




    public boolean menu(Giocatore g, Mazzo m)
    {
        System.out.println("GIOCATORE " + g.getNome() + " E' IL TUO TURNO, COSA VUOI FARE?");
        System.out.println("1) VEDERE CHI E' LO SCERIFFO");
        System.out.println("2) VEDERE LE TUE CARTE");
        System.out.println("3) SAPERE LA DISTANZA TRA TE E UN GIOCATORE");
        System.out.println("4) CONOSCERE I TUOI PUNTI VITA");
        System.out.println("0) ESCI");
        int s= t.nextInt();
        System.out.println();

        switch(s)
        {
            case 1:
                System.out.println("LO SCERIFFO E' " + giocatori.get(start).getNome());
                break;
            case 2:
                g.showMano();
                return menuMano(g.getMano(), g, m);
                //scegli cosa fare
                
            case 3: 
                System.out.println("DA QUALE GIOCATORE VUOI SAPERE LA DISTANZA?");
                String nome;
                int gioc=-1;
                do
                {
                    nome=t.next();
                    gioc=cercaNome(nome);
                }while(gioc==-1);
                System.out.println("sei distante " + calcolaDist(giocatori.get(gioc), g));
                break;
            case 4:
                System.out.println("hai " + g.getPvita() + " punti vita");
                break;
            case 0:
                System.out.println();
                System.out.println();
                
                return false;
            default: break;

            
        }

        System.out.println();
        System.out.println();
        return true;

    }
    public boolean menuMano(LinkedList<Carta> mano, Giocatore g, Mazzo m)
    {
        System.out.println(" che carta vuoi utilizzare ?");
        System.out.println();

        int scelta=0;
        int id=0;
        do{
            scelta=t.nextInt();
             id=mano.get(scelta-1).getId();
        }while(giocatori.get(scelta).equals(g));
        

        switch(id)
        {
            case 1: 
                System.out.println(" vuoi equipaggiare la" + mano.get(scelta).getEffetto()+ " ?");
                System.out.println(" 0) NO \n1) SI");
                if(t.nextInt()==1)
                {
                    g.setPistola(mano.get(scelta).getPistola());
                    return true;
                } 
                return false;
                
            case 2: 
                System.out.println("A CHI VUOI SPARARE? ");
                showGiocatoriColpibili(g, g.getPistola());
                colpisci(t.nextInt(), g , m);
                return false;
            case 3:
                System.out.println("NON PUOI UTILIZZARE ADESSO QUESTA CARTA ");
                return true;
            default : break;
            
            
        }
        return true;
        


    }


    public void colpisci(int i, Giocatore g, Mazzo m)
    {

        for(int j=0;j<giocatori.get(i).getMano().size();j++)
        {
            if(giocatori.get(i).getMano().get(j).getEffetto().equals("CARTA MANCATO: PUOI SCHIVARE UN COLPO DI UN AVVERSARIO"))
            System.out.print(giocatori.get(i).getNome() + " stai per essere colpito, vuoi utilizzare la carta mancato? \n1)si \n2) no");

            if(t.nextInt()==1)
            {
                giocatori.get(i).getMano().remove(j);
                j=giocatori.get(i).getMano().size();
            } 
            else 
            {
                giocatori.get(i).setPvita(giocatori.get(i).getPvita()-1);
        
                if(giocatori.get(i).getPvita()<=0) 
                {
                    System.out.print(giocatori.get(i).getNome() + " E stato eliminato");
                    System.out.print(giocatori.get(i).getNome() + " era un " + giocatori.get(i).getRuolo());
                    if(giocatori.get(i).getId()==1) 
                    {
                        endgame=true;
                        if(giocatori.size()>2) System.out.println("VINCONO I FUORILEGGE");
                        else{
                            if(giocatori.getLast().getId()==4) System.out.println("VINCE IL RINNEGATO");
                        }
                    }

                    if(giocatori.get(i).getRuolo().getId()==2)
                    {
                        System.out.print( " puoi pescare 3 carte " );
                        g.addCarta(m.pescaCarta());
                        g.addCarta(m.pescaCarta());
                        g.addCarta(m.pescaCarta());
                    }

                    if((g.getRuolo.getId()==1)) 
                    {

                        if(giocatori.get(i).getRuolo().getId()==3)
                        {
                            g.setMano();
                        }
                    }
                    giocatori.remove(i);

                }
            }
        }
        

            
            
        
        
    }



    public int cercaNome(String nome)
    {
        for(int i=0;i< giocatori.size();i++)
        {
            if(giocatori.get(i).getNome().equals(nome))
            {
                
                return i;
            } 
        }
        return -1;
    }

    public int calcolaDist(Giocatore g1, Giocatore g2)
    {
        int dist=0;
        
        int id1= g1.getId();
        int id2= g2.getId();
        
        dist=id2-id1;
        if(dist<0) dist=dist*(-1);
        

        

        return dist;
    }

    public void showGiocatoriColpibili(Giocatore g, Arma p)
    {
        
        int range= p.getRange();
        for(int i=0;i<giocatori.size();i++)
        {
            if(calcolaDist(g, giocatori.get(i)) <= range && !(giocatori.get(i)).equals(g)) System.out.println(giocatori.get(i).getNome());
        }
        
        
    }
    public void showGiocatori()
    {
        for(int i=0; i< giocatori.size(); i++)
        {
            System.out.println(giocatori.get(i).getNome());
        }
    }

    public void pescaCarte(int n, Mazzo m)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<giocatori.get(i).getPvita();j++)
            {
                giocatori.get(i).addCarta(m.pescaCarta());
            }
            
        }
    }

}
