package test;

import diadia.Giocatore;
import diadia.Attrezzo;
import diadia.Borsa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GiocatoreTest {
	Giocatore player;
	Attrezzo martello;
	Attrezzo motosega;	// Troppo pesante
	Borsa borsa;

	@BeforeEach
	void setUp() throws Exception {
		player = new Giocatore();
		martello = new Attrezzo("Martello", 5);
		motosega = new Attrezzo("Motosega", 20);
		borsa = new Borsa();
	}

	@Test
	void testAddAttrezzo() {
		assertTrue(player.addAttrezzo(martello));
		
		assertFalse(player.addAttrezzo(motosega));
	}

}
