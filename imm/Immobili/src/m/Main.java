package m;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Main {

	public static void main(String[] args) {
		JFrame f = new JFrame("CATASTO");
		f.setSize(500, 300);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar bar = new JMenuBar();
		JMenu prop = new JMenu("CITTA'");
		
		ArrayList<Citta> elencoCitta = Citta.caricaCitta();
		ArrayList<Immobili> elencoImmobili = Immobili.caricaImmobili();
		ArrayList<Persona> elencoPersone = Persona.caricaPersona();
		
		for(Citta c : elencoCitta) {
			JMenu voce = new JMenu(c.getCitta());
			
			JMenu cc = new JMenu(c.getCodiceCatastale());
			
			for(Immobili i : elencoImmobili) {
				if(c.getCodiceCatastale().equals(i.getCc())) {
					String snc = i.getNc() + " " + i.getDes() + " " + i.getV() + "€";
					JMenu nc = new JMenu(snc);
					
					for(String proprietari : i.getProprietari()) {
						JMenuItem p = new JMenuItem(proprietari);
						
						nc.add(p);
					}					
					cc.add(nc);				
				}
			}
			voce.add(cc);			
			prop.add(voce);
		}
		
		JMenu pers = new JMenu("PROPRIETARI");
		for(Persona p : elencoPersone) {
			String ncf = p.getNome() + " " + p.getCf();
			JMenu propri = new JMenu(ncf);
			
			for(String proprieta : p.getProprieta()) {
				JMenuItem ed = new JMenuItem(proprieta);
				propri.add(ed);
			}
			pers.add(propri);
		}
		bar.add(pers);
		bar.add(prop);
		f.setJMenuBar(bar);
		
		f.setVisible(true);
	}

}
