package prop.sim;

import java.util.Set;

import prop.pers.Persona;

public class Contatto {

	private int passoSimulazione; //il passo della simulazione in cui è avvenuto il contatto
	private Set<Persona> coinvolti;
	private Coordinate luogo;

	public Contatto(int passoSimulazione, Set<Persona> coinvolti, Coordinate luogo) {
		if (coinvolti.isEmpty()) throw new IllegalArgumentException();
		this.passoSimulazione = passoSimulazione;
		this.coinvolti = coinvolti;
		this.luogo = luogo;
	}

	public Set<Persona> getCoinvolti() {
		return this.coinvolti;
	}

	public int getPassoSimulazione() {
		return this.passoSimulazione;
	}
	
	public int numeroCoinvolti() {
		return this.coinvolti.size();
	}
	
	public Coordinate getLuogo() {
		return this.luogo;
	}

	@Override
	public String toString() {
		return "[" + this.getClass().getSimpleName() + 
				": era " + this.passoSimulazione + 
				", #coinvolti " + this.coinvolti.size() + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		if( o==null || this.getClass()!=o.getClass() )
			return false;
		
		Contatto that = (Contatto)o;
		return (this.getPassoSimulazione() == that.getPassoSimulazione() &&
					this.numeroCoinvolti() == that.numeroCoinvolti() &&
					this.getLuogo().equals(that.getLuogo()));
	}
	
	@Override
	public int hashCode() {
		return this.getClass().hashCode() + this.getPassoSimulazione() + 
				this.numeroCoinvolti() + this.getLuogo().hashCode();
	}

}
