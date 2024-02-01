package prop.pers;

import static prop.gui.CostantiGUI.*;
import static prop.gui.LettoreImmagini.leggiImmagineOggetto;

import java.awt.Image;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import prop.sim.Ambiente;
import prop.sim.Coordinate;
import prop.sim.GeneratoreCasuale;

public class Rossa {

	static final private Image IMMAGINE_ROSSA = leggiImmagineOggetto(RISORSA_IMMAGINE_ROSSO);
	static private int progId;
	private final int id;
	private Ambiente ambiente;
	private Coordinate posizione;    // posizione corrente

	public Rossa(Ambiente ambiente) {		
		this.ambiente = ambiente;
		this.posizione = GeneratoreCasuale.posizioneCasuale();
		this.id = progId++;
	}

	public Ambiente getAmbiente() {
		return this.ambiente;
	}

	public Image getImmagine() {
		return IMMAGINE_ROSSA;
	}

	public int getId() {
		return this.id;
	}

	public Coordinate getPosizione() {
		return this.posizione;
	}

	public void setPosizione(Coordinate nuova) {
		this.posizione = nuova;
	}

	public void mossa() {
		List<Coordinate> adiacenti = new LinkedList<>(this.getAmbiente().adiacentiA(this.getPosizione()));
		Collections.shuffle(adiacenti);
		this.setPosizione(adiacenti.get(0));
	}

	@Override
	public String toString() {
		return Rossa.class.getSimpleName()+getId();
	}

}
