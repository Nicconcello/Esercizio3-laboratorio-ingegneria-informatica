package m;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Persona {
	private String nome;
	private String cf;
	private List<String> proprieta;
	
	public Persona(String nome, String cf, List<String>proprieta) {
		this.nome = nome;
		this.cf = cf;
		this.proprieta = proprieta;
	}

	
	public String getNome() { return nome; }
	public String getCf() { return cf; }
	public List<String> getProprieta() { return proprieta; }

	public static ArrayList<Persona> caricaPersona() {
	    // 1. Lista principale che conterrà le Persone
	    ArrayList<Persona> listaPersone = new ArrayList<>();
	    String percorsoFile = "persona.txt"; 
	    File file = new File(percorsoFile);
	    
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	        String linea;
	        while ((linea = br.readLine()) != null) {
	            
	            // Split basato sullo spazio
	            String[] parti = linea.split(" ");
	            
	            // Controllo di sicurezza: servono almeno Nome, Cognome e CF
	            if (parti.length >= 3) {
	                String nome = parti[0].trim() + " " + parti[1].trim(); 
	                String cf = parti[2].trim();                          
	                
	                // 2. Ricostruzione della parte "Proprietà" (dal 4° elemento in poi)
	                StringBuilder sb = new StringBuilder();
	                for (int i = 3; i < parti.length; i++) {
	                    sb.append(parti[i]).append(" ");
	                }
	                String tuttoProprieta = sb.toString().trim(); 
	                
	                // 3. Lista locale per le proprietà di QUESTA singola persona
	                List<String> listaProprietaSingola = new ArrayList<>();
	                
	                if (!tuttoProprieta.isEmpty()) {
	                    String[] arrayProp = tuttoProprieta.split(",");
	                    for(String s : arrayProp) {
	                        listaProprietaSingola.add(s.trim());
	                    }
	                }

	                // 4. Creazione dell'oggetto Persona
	                // Assumiamo che il costruttore sia: new Persona(String nomeCompleto, String cf, List<String> proprieta)
	                Persona nuovaPersona = new Persona(nome, cf, listaProprietaSingola);
	                
	                // 5. IMPORTANTE: Aggiungiamo la persona alla lista principale (listaPersone), non a quella delle proprietà!
	                listaPersone.add(nuovaPersona);
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    // 6. Restituiamo la lista principale definita all'inizio
	    return listaPersone;
	}
}
