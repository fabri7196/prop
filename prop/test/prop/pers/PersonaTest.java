package prop.pers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import prop.pers.Bianca;
import prop.pers.Rossa;
import prop.sim.Ambiente;

/** 
 * Suggerimento: Controllare che questi test abbiano successo sia
 * prima che dopo aver operato le modifiche suggerite<BR/>
 * RIVEDERE {@link #testIdProgressiviPerSani()}<BR/>
 * COMPLETARE {@link #testIdProgressiviPerSaniEInfetti()}<BR/>
 * <B>(VEDI DOMANDA 2)</B>
 */
public class PersonaTest {

	private Ambiente ambiente;
	
	@Before
	public void setUp() throws Exception {
		this.ambiente = new Ambiente();
	}

	@Test
	public void testIdProgressiviPerPersoneStessoTipo() {
		// DA RIVEDERE VEDI DOMANDA 2a
		assertEquals("Gli id sono progressivi base 0", 0, new Bianca(this.ambiente).getId());
		assertEquals("Gli id sono progressivi base 0", 1, new Rossa(this.ambiente).getId());
	}

	@Test
	public void testIdProgressiviPerPersoneTipoDiverso() {
		// DA COMPLETARE VEDI DOMANDA 2a
		// Tipi di persone diverse hanno la stessa serie di id progressivi
		fail("DA COMPLETARE");
	}

}
