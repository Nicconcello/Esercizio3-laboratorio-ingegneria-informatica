package m;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Citta {
	private String citta;
	private String cc;
	
	public Citta(String citta, String cc) {
		this.citta = citta;
		this.cc = cc;
	}
	
	public String getCitta() { return citta; }
	public String getCodiceCatastale() { return cc; }
	
	public static ArrayList<Citta> caricaCitta() {
		ArrayList<Citta> listaCitta = new ArrayList<>(); // Creiamo una lista vuota
		String percorsoFile = "citta.txt";
		File file = new File(percorsoFile);
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
             
            	String[] parti = linea.split(" ");
            	
            	if (parti.length == 2) {
                    String nomeLetto = parti[0].trim(); // trim() toglie spazi extra
                    String codiceLetto = parti[1].trim();
                    
                    // Creiamo la nuova città e la aggiungiamo alla lista
                    Citta nuovaCitta = new Citta(nomeLetto, codiceLetto);
                    listaCitta.add(nuovaCitta);
            	}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		return listaCitta;
	}
}
