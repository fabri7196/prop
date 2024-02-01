package prop.pers;

import static prop.gui.CostantiGUI.RISORSA_IMMAGINE_BIANCO;
import static prop.gui.LettoreImmagini.leggiImmagineOggetto;

import java.awt.Image;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import prop.gui.CostantiGUI;
import prop.sim.Ambiente;
import prop.sim.Contatto;
import prop.sim.Coordinate;

public class NonPredicatore extends Persona {

	static final private Image IMMAGINE_BIANCA = leggiImmagineOggetto(RISORSA_IMMAGINE_BIANCO);
//	static private int progId;
//	private final int id;
	private Image immagine;
	

	public NonPredicatore(Ambiente ambiente) {		
		super(ambiente);
		this.immagine = IMMAGINE_BIANCA;
	}

	public Image getImmagine() {
		return this.immagine;
	}
	
	public void setImmagine(String immagine) {
		this.immagine = leggiImmagineOggetto(immagine);
	}
	
	@Override
	public void mossa() {
//		List<Coordinate> adiacenti = new LinkedList<>(this.getAmbiente().adiacentiA(this.getPosizione()));
//		List<Coordinate> posizioniPredicatori = new LinkedList<>();
//		
//		for(Coordinate coordinata : adiacenti) {
//			Set<Persona> persone = this.getAmbiente().getPersona(coordinata);
//			for(Persona predicatoriEnon : persone) {
//				if(predicatoriEnon.getClass() != this.getClass())
//					posizioniPredicatori.add(coordinata);
//			}
//		}
//		
//		double distanza=0;
//		Coordinate posizioneDoveAndare;
//		Collections.shuffle(adiacenti);
//		
//		posizioneDoveAndare = adiacenti.get(0);
//		 
//		for(Coordinate coordinata : adiacenti) {
//			for(Coordinate coordinataPredicatore : posizioniPredicatori) {
//				double distanzaMaggiore = Coordinate.distanza(coordinata,coordinataPredicatore);
//				if(distanzaMaggiore > distanza) {
//					distanza = distanzaMaggiore;
//					posizioneDoveAndare = coordinata;
//				}
//			}
//		}
//		
//		this.setPosizione(posizioneDoveAndare);
		
		List<Coordinate> adiacenti = new LinkedList<>(this.getAmbiente().adiacentiA(this.getPosizione()));
		
		for(Coordinate coordinata : adiacenti) {
			if(this.getAmbiente().getPersona(coordinata).getClass() == this.getClass())
				adiacenti.remove(coordinata);
		}
		
		Collections.shuffle(adiacenti);
		this.setPosizione(adiacenti.get(0));
	}

	@Override
	public String toString() {
		return NonPredicatore.class.getSimpleName()+this.getId();
	}

	@Override
	public void avvenuto(Contatto contatto) {
		// ( VEDI DOMANDA 2b ) 
		// Metodo invocato ogni qual volta avviene un Contatto con questa
		for(Persona persona : contatto.getCoinvolti()) {
			if(persona.getClass() == Predicatore.class)
				this.setImmagine(CostantiGUI.RISORSA_IMMAGINE_GIALLO);
		}
	}

}
