package m;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Immobili {
	private String cc;
	private String nc;
    private String des;
    private Double v;
    private List<String> proprietari; // Inizializzato nel costruttore

    public Immobili(String cc, String nc, String des, Double v, List<String> proprietari) {
        this.cc = cc;
    	this.nc = nc;
        this.des = des;
        this.v = v;
        this.proprietari = proprietari;
    }

    // Getter (Utili per stampare i dati dopo)
    public String getCc() { return cc; }
    public String getNc() { return nc; }
    public String getDes() { return des; }
    public Double getV() { return v; }
    public List<String> getProprietari() { return proprietari; }

    public static ArrayList<Immobili> caricaImmobili() {
        // 1. La lista deve contenere oggetti Immobili, non String
        ArrayList<Immobili> listaImmobili = new ArrayList<>();
        String percorsoFile = "immobili.txt"; 
        File file = new File(percorsoFile);
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
             
                
                String[] parti = linea.split(" ");
                
                // Controlliamo di avere almeno 4 parti (Codice, Descrizione, Valore, Proprietari)
                if (parti.length >= 4) {
                    String cc = parti[0].trim(); 
                    String nc = parti[1].trim(); 
                    String des = parti[2] + " " + parti[3];
                    
                    // 3. Parsing da String a Double per il valore
                    String prezzoStr = parti[4].replace(",", ".");
                    Double v = Double.parseDouble(prezzoStr);
                    
                    // 4. Proprietari (Dalla posizione 5 fino alla fine)
                    // Dobbiamo ricostruire la stringa perché lo split ha separato nomi e cognomi
                    StringBuilder sb = new StringBuilder();
                    for (int i = 5; i < parti.length; i++) {
                        sb.append(parti[i]).append(" ");
                    }
                    String tuttoProprietari = sb.toString().trim(); // Es: "Luca Bianchi, Maria Rossi"
                    
                    // Ora dividiamo i proprietari usando la virgola come separatore
                    String[] arrayProp = tuttoProprietari.split(",");
                    List<String> listaProprietari = new ArrayList<>();
                    for(String s : arrayProp) {
                        listaProprietari.add(s.trim()); // trim() pulisce gli spazi attorno al nome
                    }

                    // 5. Creiamo un oggetto 'Immobili'
                    Immobili nuovoImmobile = new Immobili(cc, nc, des, v, listaProprietari);
                    listaImmobili.add(nuovoImmobile);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaImmobili;
    }
}
