package src.it.uniroma3.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.it.uniroma3.diadia.attrezzi.Attrezzo;
import src.it.uniroma3.diadia.giocatore.Borsa;
import src.it.uniroma3.diadia.giocatore.Giocatore;

class GiocatoreTest {
	Giocatore player;
	Attrezzo martello;
	Attrezzo motosega;	// Troppo pesante

	@BeforeEach
	void setUp() throws Exception {
		player = new Giocatore();
		martello = new Attrezzo("Martello", 5);
		motosega = new Attrezzo("Motosega", 20);
	}

	@Test
	void testAddAttrezzo() {
		assertTrue(player.addAttrezzo(martello));
		
		assertFalse(player.addAttrezzo(motosega));
		
		player.addAttrezzo(martello);
		assertTrue(player.getBorsa().hasAttrezzo("Martello"));
	}
	
	@Test
	void testRemoveAttrezzo() {
		player.addAttrezzo(martello);
		
		assertTrue(player.removeAttrezzo("Martello"));
		
		assertFalse(player.removeAttrezzo("Motosega"));
		
		player.removeAttrezzo("Martello");
		assertFalse(player.getBorsa().hasAttrezzo("Martello"));
	}
}
