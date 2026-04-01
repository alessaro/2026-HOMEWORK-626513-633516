package src.it.uniroma3.test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.it.uniroma3.diadia.Partita;
import src.it.uniroma3.diadia.ambienti.Stanza;

class PartitaTest {
	private Partita partita;
	private Stanza prova1;
	private Stanza prova2;

	@BeforeEach
	void setUp() throws Exception {
		partita = new Partita();
		prova1 = new Stanza("Prova 1");
		prova2 = new Stanza("Prova 2");
	}

	@Test
	void testIsFinita() {
		partita.getPlayer().setCfu(0);
		assertTrue(partita.isFinita());
		partita.getPlayer().setCfu(20);
		
		partita.setStanzaCorrente(prova1);
		partita.getLabirinto().setUscita(prova1);
		assertTrue(partita.isFinita());
		
		partita.getLabirinto().setUscita(prova2);
		assertFalse(partita.isFinita());
		
		partita.setFinita();	
		assertTrue(partita.isFinita());
	}

}
