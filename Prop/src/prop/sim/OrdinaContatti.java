package prop.sim;

import java.util.Comparator;

public class OrdinaContatti implements Comparator<Contatto> {
	@Override
	public int compare(Contatto c1, Contatto c2) {
		return c1.getCoinvolti().size() - c2.getCoinvolti().size();
	}

}
