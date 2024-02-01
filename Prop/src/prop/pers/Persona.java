package prop.pers;

import java.awt.Image;

import prop.sim.Ambiente;
import prop.sim.Contatto;
import prop.sim.Coordinate;
import prop.sim.GeneratoreCasuale;

public class Persona {
	static private int progId;
	private int id;
	
	private Coordinate posizione;
	private Ambiente ambiente;
	
	public Persona(Ambiente ambiente) {
		this.id = progId;
		this.posizione = GeneratoreCasuale.posizioneCasuale();
		this.ambiente = ambiente;
		progId++;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setID(int i) {
		this.id = i;
	}
	
	public Coordinate getPosizione() {
		return this.posizione;
	}

	public void setPosizione(Coordinate nuova) {
		this.posizione = nuova;
	}
	
	public Ambiente getAmbiente() {
		return this.ambiente;
	}

	public void mossa() {}

	public void avvenuto(Contatto contatto) {}

	public Image getImmagine() {
		return this.getImmagine();
	}
	
	@Override
	public boolean equals(Object o) {
		if( o==null || this.getClass() != o.getClass() )
			return false;
		
		Persona that = (Persona)o;
		return (this.getId() == that.getId());
	}
	
	@Override
	public int hashCode() {
		return this.getClass().hashCode()+ this.getId();
	}
	
}
