package prop.pers;

import static prop.gui.CostantiGUI.RISORSA_IMMAGINE_ROSSO;
import static prop.gui.LettoreImmagini.leggiImmagineOggetto;

import java.awt.Image;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import prop.sim.Ambiente;
import prop.sim.Contatto;
import prop.sim.Coordinate;

public class Predicatore extends Persona {

	static final private Image IMMAGINE_ROSSA = leggiImmagineOggetto(RISORSA_IMMAGINE_ROSSO);
//	static private int progId;
//	private final int id;
	private Image immagine;

	public Predicatore(Ambiente ambiente) {
		super(ambiente);
		this.immagine = IMMAGINE_ROSSA;
	}

	public Image getImmagine() {
		return this.immagine;
	}
	
	public void setImmagine(String immagine) {
		this.immagine = leggiImmagineOggetto(immagine);
	}
	
	@Override
	public void avvenuto(Contatto contatto) {}

	@Override
	public void mossa() {
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
		return Predicatore.class.getSimpleName()+this.getId();
	}

}
