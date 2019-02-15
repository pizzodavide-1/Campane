package campane;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Campane {

    /**
     * @author pizzo_davide
     *
     * @brief vengono creati i 3 thread che contengono il suono delle
     * campane;vengono fatti partire e si fanno partire gli output finchè non si
     * schiaccia un tasto qualsiasi sulla tastiera
     *
     *
     * Il main crea i 3 thread di tipo 'ThCampane' , passando come parametro il
     * suono della campana e li fa partire. Poi finchè non riceve "il segnale di
     * stop" continua,altrimenti li ferma tutti e 3.
     *
     */
    public static void main(String[] args) {
        try {

            Scanner input = new Scanner(System.in);
            java.io.BufferedReader console = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
            boolean finito = false;
            boolean usaYeld = false;
            boolean usaSlep = true;

            DatiCondivisi dati = new DatiCondivisi();

            Semaforo sem1 = new Semaforo(1);
            Semaforo sem2 = new Semaforo(0);
            Semaforo sem3 = new Semaforo(1);

            ThCampane din = new ThCampane("DIN", dati, sem1);
            ThCampane don = new ThCampane("DON", dati, sem2);
            ThCampane dan = new ThCampane("DAN", dati, sem3);
            ThV vedi = new ThV(dati);

            System.out.println("Chi farà più rintocchi(din/don/dan)?");
            System.out.println("Per din-->premi tasto '1'");
            System.out.println("Per dan-->premi tasto '2'");
            System.out.println("Per don-->premi tasto '3'");
            int r = input.nextInt();

            din.start();
            don.start();
            dan.start();
            vedi.start();

            while (!finito) {
                dati.visualizzaLinee();
                String s = console.readLine();
                if (s.endsWith(" ")) {
                    finito = true;
                } else {
                    clearConsole();
                }
            }

            din.interrupt();
            don.interrupt();
            dan.interrupt();
            vedi.interrupt();

            din.join();
            don.join();
            dan.join();
            vedi.join();

            int max = 0;
            int nRintocchi = 0;
            if (dati.getDin() > max) {
                nRintocchi = 1;
                max = dati.getDin();
            }
            if (dati.getDan() > max) {
                nRintocchi = 2;
                max = dati.getDan();
            }
            if (dati.getDon() > max) {
                nRintocchi = 3;
                max = dati.getDon();
            }

            String nr = "";
            if (nRintocchi == 1) {
                dati.setNr("DIN");

            }
            if (nRintocchi == 2) {
                dati.setNr("DAN");

            }
            if (nRintocchi == 3) {
                dati.setNr("DON");

            }

            String rs = "";
            if (r == 1) {
                dati.setRs("DIN");

            }
            if (r == 2) {
                dati.setRs("DAN");

            }
            if (r == 3) {
                dati.setRs("DON");
            }

        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(Campane.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @author pizzo_davide
     *
     * @brief il metodo 'clearConsole' serve a pulire la console dopo il lancio
     * del programma
     *
     */
    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException ex) {
        }
    }

}
