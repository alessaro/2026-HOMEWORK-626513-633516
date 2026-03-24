package test;
import diadia.Partita;
import diadia.Giocatore;
import diadia.Stanza;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PartitaTest {
	private Partita partita;
	private Stanza prova1;
	private Stanza prova2;
	private Giocatore player;

	@BeforeEach
	void setUp() throws Exception {
		partita = new Partita();
		prova1 = new Stanza("Prova 1");
		prova2 = new Stanza("Prova 2");
		player = new Giocatore();
	}

	@Test
	void testIsFinita() {
		player.setCfu(0);
		assertTrue(partita.isFinita());
		player.setCfu(20);
		
		partita.setStanzaCorrente(prova1);
		partita.setStanzaVincente(prova1);
		assertTrue(partita.isFinita());
		
		partita.setStanzaVincente(prova2);
		assertFalse(partita.isFinita());
		
		partita.setFinita();
		assertTrue(partita.isFinita());
	}

}
