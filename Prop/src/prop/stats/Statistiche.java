package prop.stats;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import prop.sim.Contatto;
import prop.sim.OrdinaContatti;
import prop.sim.Simulatore;

/**
 * <B>DA COMPLETARE (VEDI DOMANDA 3)</B>
 */
public class Statistiche {

	synchronized public void stampaFinale(Simulatore simulatore) {
		final List<Contatto> contatti = simulatore.getContatti();

		System.out.println(contatti.size() + " contatti rilevati." );
		System.out.println(simulatore.getContatti());
		System.out.println();

		final Map<Integer,Set<Contatto>> mappa = produciStatistiche(simulatore.getContatti());
		System.out.println("Contatti per persona:");
		stampaStatistiche(mappa);
		System.out.println();
	}

	public Map<Integer, Set<Contatto>> produciStatistiche(List<Contatto> contatti) {
		// DA COMPLETARE (VEDI DOMANDA 3)
		Map<Integer,Set<Contatto>> risultato = new HashMap<>();
		Set<Contatto> contattiDelPasso;
		
		for(Contatto unContatto : contatti) {
			contattiDelPasso = risultato.get(unContatto.getPassoSimulazione());
			if( contattiDelPasso == null ) {
				contattiDelPasso = new TreeSet<>(new OrdinaContatti());
				contattiDelPasso.add(unContatto);
				risultato.put(unContatto.getPassoSimulazione(), contattiDelPasso);
			}
			contattiDelPasso.add(unContatto);
		}
		
		return risultato;
	}

	/**
	 * <EM>N.B. UTILE PER STAMPARE RISULTATI DOMANDA 3</EM>
	 */
	private void stampaStatistiche(final Map<Integer, Set<Contatto>> mappa) {
		for(Object key : mappa.keySet()) {
			final Set<Contatto> l = mappa.get(key);
			System.out.print(key + " è stato coinvolto in :");
			for(Object c : l) 
				System.out.print(c.toString() + " ");
			System.out.println();
		}
	}
}
