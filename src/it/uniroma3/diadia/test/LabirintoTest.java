package src.it.uniroma3.test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.it.uniroma3.diadia.ambienti.Labirinto;
import src.it.uniroma3.diadia.ambienti.Stanza;

class LabirintoTest {
	Labirinto lab;
	Stanza prova1, prova2;

	@BeforeEach
	void setUp() throws Exception {
		lab = new Labirinto();
		prova1 = new Stanza("Prova 1");
		prova2 = new Stanza("Prova 2");
	}

	@Test
	void testSetEntrataUscita() {
		lab.setEntrata(prova1);
		lab.setUscita(prova2);
		
		assertEquals(prova1.getNome(), lab.getEntrata().getNome());
		
		assertEquals(prova2.getNome(), lab.getUscita().getNome());
		
		assertNotEquals(prova1.getNome(), lab.getUscita().getNome());
		
		assertNotEquals(prova2.getNome(), lab.getEntrata().getNome());
	}

}
