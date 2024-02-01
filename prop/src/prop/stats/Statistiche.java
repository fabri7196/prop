package prop.stats;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import prop.sim.Contatto;
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

		final Map<Object,Set<Object>> mappa = produciStatistiche(simulatore.getContatti());
		System.out.println("Contatti per persona:");
		stampaStatistiche(mappa);
		System.out.println();
	}

	public Map<Object, Set<Object>> produciStatistiche(List<Contatto> contatti) {
		// DA COMPLETARE (VEDI DOMANDA 3)
		return Collections.emptyMap();
	}

	/**
	 * <EM>N.B. UTILE PER STAMPARE RISULTATI DOMANDA 3</EM>
	 */
	private void stampaStatistiche(final Map<Object, Set<Object>> mappa) {
		for(Object key : mappa.keySet()) {
			final Set<Object> l = mappa.get(key);
			System.out.print(key + " è stato coinvolto in :");
			for(Object c : l) 
				System.out.print(c.toString() + " ");
			System.out.println();
		}
	}
}
