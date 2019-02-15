/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campane;

/**
 *
 * @author pizzo_davide
 */
public class ThV extends Thread{
    
    private DatiCondivisi ptrDati;
    public ThV(DatiCondivisi dati){
     this.ptrDati = dati;
    }
    public void output(){
    System.out.println("Numero rintocchi:");
            System.out.println("din --> " + ptrDati.getDin());
            System.out.println("dan --> " + ptrDati.getDan());
            System.out.println("don --> " + ptrDati.getDon());
            System.out.println("Rintocco che c'è stato più spesso: " + ptrDati.getNr());
            System.out.println("Rintocco 'scommesso' dall'utente: " + ptrDati.getRs());

            System.out.println("Ciao,ci vediamo alla prossima");
    }
             
}
