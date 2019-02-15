/**
 * @author pizzo_davide
 *
 * La classe 'ThCampane' serve per gestire i 3 thread,che saranno usati nel main
 *
 */
package campane;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThCampane extends Thread {

    /**
     * @author pizzo_davide
     *
     * Dichiarazione di un attributo di tipo String,che conterrà la parola del
     * thread
     */
    private String suono;
    /**
     * @author pizzo_davide
     *
     * Dichiarazione di un attributo di tipo boolean,che serve per controllare
     * se si puo andare avanti oppure no.
     *
     */
    private boolean continua;

    /**
     * @author pizzo_davide
     *
     * Dichiarazione dell'attributo che servirà a salvare il numero di rintocchi
     * di campana
     */
    private DatiCondivisi ptrDati;
/**
     * @author pizzo_davide
     *
     * Dichiarazione dell'attributo che servirà a puntare al semaforo
     */
    private Semaforo ptrMutex;

    /**
     * @author pizzo_davide
     *
     * @brief Costruttore con parametri che permette di inizializzare il numero
     * del cavallo, un oggetto nel quale verranno memorizzate informazione sul
     * cavallo e l'utilizzo o meno dello yeld e dello sleep.
     *
     * @param nomeSuono il parametro serve per passare al metodo un valore di
     * tipo String per inizializzare l'attributo che memorizza il suono
     * @param mutex puntatore al semaforo
     * @param dati il parametro serve a passare al metodo un valore di tipo
     * DatiCondivisi dove verrà memorizzato il numero di volte in cui ce un
     * suono
     */
    public ThCampane(String nomeSuono, DatiCondivisi dati, Semaforo mutex) {

        this.continua = true;

        this.suono = nomeSuono;
        this.ptrDati = dati;
        this.ptrMutex = mutex;
    }

    /**
     * @author pizzo_davide
     *
     * @brief Metodo che rappresenta il main del Thread
     *
     * Il metodo serve a simulare il rintocco di una campana.La campana suona
     * finchè non si fa terminare. Il Thread provvederà a salvare il numero dei
     * rintocchi.
     */
    @Override
    public void run() {
        int nRintocchi = 0;
        Random nRand = new Random();
        while (true) {

            nRintocchi++;
            ptrMutex.Wait();
            ptrDati.aggiungiLinea(suono);
            ptrMutex.Signal();

            if (Thread.currentThread().isInterrupted()) {
                break;

            }

        }
        ptrMutex.Wait();
        switch (this.suono) {

            case "DIN":
                ptrDati.setDin(nRintocchi);
                ptrMutex.Signal();
                break;

            case "DON":
                ptrDati.setDon(nRintocchi);
                ptrMutex.Signal();
                break;

            case "DAN":
                ptrDati.setDan(nRintocchi);
                ptrMutex.Signal();
                break;

        }

    }

}
