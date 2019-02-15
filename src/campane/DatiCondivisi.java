package campane;

/**
 * @author pizzo_davide
 *
 * @brief Classe DatiCondivisi, meemorizza e restituisce il numero di rintocchi
 * di ogni campana.
 */
public class DatiCondivisi  {

    /**
     * @author pizzo_davide
     *
     * Dichiarazione dell'attributo che memorizza il numero di volte che suona
     * 'din'
     *
     */
    private int din;
    /**
     * @author pizzo_davide
     *
     * Dichiarazione dell'attributo che memorizza il numero di volte che suona
     * 'don'
     *
     */
    private int don;
    /**
     * @author pizzo_davide
     *
     * Dichiarazione dell'attributo che memorizza il numero di volte che suona
     * 'dan'
     *
     */
    private int dan;
/**
     * @author pizzo_davide
     *
     * Dichiarazione dell'attributo che memorizza tutti i suoni
     * 
     *
     */
    String[] schermo;
/**
     * @author pizzo_davide
     *
     * Dichiarazione dell'attributo che memorizza quale è la prima posizione libera disponibile dell'attributo 'schermo'
     *
     */
    int primaPosizioneLibera;

    
    /**
     * @author pizzo_davide
     *
     * Dichiarazione dell'attributo che memorizza qual'è stato il rintocco di campana che ci è stato più spesso
     *
     */
    private String nr; 
    /**
     * @author pizzo_davide
     *
     * Dichiarazione dell'attributo che memorizza quale è stato il rintocco scommesso dall'utenza
     *
     */
    private String rs; //rintocco scommesso
    /**
     * @author pizzo_davide
     *
     * @brief Metodo costruttore senza parametri che inizializza a 0 i numeri di
     * rintocchi di ogni campana.
     */
    public DatiCondivisi() {
        this.din = 0;
        this.don = 0;
        this.dan = 0;
        this.nr="";
        this.rs="";
        schermo = new String[100000];
        primaPosizioneLibera = 0;
    }
/**
     * @author pizzo_davide
     *
     * @brief Metodo accessore di default che restituisce il rintocco più spesso
     * @return nr viene restituito il rintoccoche ci è stato più spesso
     */
    public String getNr() {
        return nr;
    }
/**
     * @author pizzo_davide
     *
     * @brief Metodo modificatore di default che modifica il valore del rintocco che ci è stato più spesso
     * @param nr il paramtero serve a passare al metodo una stringa contenente il suono, con
     * cui modificare il valore dell'attributo rs, che corrisponde al rintocco  che ci è stao più spesso
     */
    public void setNr(String nr) {
        this.nr = nr;
    }
/**
     * @author pizzo_davide
     *
     * @brief Metodo accessore di default che restituisce il rintocco scommesso
     * @return nr viene restituito il rintocco scommesso dall'utente
     */
    public String getRs() {
        return rs;
    }
 /**
     * @author pizzo_davide
     *
     * @brief Metodo modificatore di default che modifica il valore del rintocco scommesso
     * @param rs il paramtero serve a passare al metodo una stringa contenente il suono, con
     * cui modificare il valore dell'attributo rs, che corrisponde al rintocco scommesso dall'utenza
     */
    public void setRs(String rs) {
        this.rs = rs;
    }

    /**
     * @author pizzo_davide
     *
     * @brief Metodo accessore di default che restituisce il numero di rinrocchi
     * della campana 'din'
     * @return din viene restituito un numero intero che indica il numero di
     * rintocchi della campana 'din'
     */
    public int getDin() {
        return din;
    }

    /**
     * @author pizzo_davide
     *
     * @brief Metodo modificatore di default che modifica il numero di rintocchi
     * della campana 'din'
     * @param din il paramtero serve a passare al metodo un valore intero, con
     * cui modificare il valore dell'attributo din, che corrisponde al numero di
     * rintocchi della campana1
     */
    public void setDin(int din) {
        this.din = din;
    }

    /**
     * @author pizzo_davide
     *
     * @brief Metodo accessore di default che restituisce il numero di rinrocchi
     * della campana 'don'
     * @return don viene restituito un numero intero che indica il numero di
     * rintocchi della campana 'don'
     */
    public int getDon() {
        return don;
    }

    /**
     * @author pizzo_davide
     *
     * @brief Metodo modificatore di default che modifica il numero di rintocchi
     * della campana 'don'
     * @param don il paramtero serve a passare al metodo un valore intero, con
     * cui modificare il valore dell'attributo don, che corrisponde al numero di
     * rintocchi della campana2
     */
    public void setDon(int don) {
        this.don = don;
    }

    /**
     * @author pizzo_davide
     *
     * @brief Metodo accessore di default che restituisce il numero di rinrocchi
     * della campana 'dan'
     * @return dan viene restituito un numero intero che indica il numero di
     * rintocchi della campana 'dan'
     */
    public int getDan() {
        return dan;
    }

    /**
     * @author pizzo_davide
     *
     * @brief Metodo modificatore di default che modifica il numero di rintocchi
     * della campana 'dan'
     * @param dan il paramtero serve a passare al metodo un valore intero, con
     * cui modificare il valore dell'attributo dan, che corrisponde al numero di
     * rintocchi della campana3
     */
    public void setDan(int dan) {
        this.dan = dan;
    }
/**
     * @author pizzo_davide
     *
     * @brief Il metodo serve ad aggiungere una nuova linea nella prima posizione libera trovata nell'array
     *
     */
    public void visualizzaLinee() {
        for (int i = 0; i < primaPosizioneLibera; i++) {
            System.out.println(schermo[i]);
        }
    }
/**
     * @author pizzo_davide
     *
     * @param s indica la parola che verrà stampata nella posizione libera
     * 
     * @brief il metodo serve a stampare una string passata come parametro nella prima posizione libera dell'array 'schermo'
     */
    public void aggiungiLinea(String s) {
        schermo[primaPosizioneLibera] = s;
        primaPosizioneLibera++;
    }

}
