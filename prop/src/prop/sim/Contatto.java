package prop.sim;

import java.util.Set;

import prop.pers.Bianca;

public class Contatto {

	private int passoSimulazione; //il passo della simulazione in cui è avvenuto il contatto
	private Set<Bianca> coinvolti;
	private Coordinate luogo;

	public Contatto(int passoSimulazione, Set<Bianca> coinvolti, Coordinate luogo) {
		if (coinvolti.isEmpty()) throw new IllegalArgumentException();
		this.passoSimulazione = passoSimulazione;
		this.coinvolti = coinvolti;
		this.luogo = luogo;
	}

	public Set<Bianca> getCoinvolti() {
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

}
