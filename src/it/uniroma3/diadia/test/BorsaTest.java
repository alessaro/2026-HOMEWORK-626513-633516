package src.it.uniroma3.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.it.uniroma3.diadia.attrezzi.Attrezzo;
import src.it.uniroma3.diadia.giocatore.Borsa;

class BorsaTest {
	Attrezzo martello;
	Attrezzo pesante;
	Borsa borsa;

	@BeforeEach
	void setUp() throws Exception {
		borsa = new Borsa();
		martello = new Attrezzo("Martello", 5);
		pesante = new Attrezzo("Pesante", 15);
	}

	@Test
	void testAddAttrezzo() {
		assertTrue(borsa.addAttrezzo(martello));
		
		assertFalse(borsa.addAttrezzo(pesante));
		
		borsa.addAttrezzo(martello);
		assertFalse(borsa.addAttrezzo(martello));
	}
	
	@Test
	void testGetAttrezzo() {
		assertNull(borsa.getAttrezzo("Martello"));
		
		borsa.addAttrezzo(martello);
		assertEquals(martello.getNome(), borsa.getAttrezzo("Martello").getNome());
		
		assertNull(borsa.getAttrezzo("Pesante"));
	}
	
	@Test
	void testRemoveAttrezzo() {
		assertNull(borsa.removeAttrezzo("Martello"));
		
		borsa.addAttrezzo(martello);
		assertEquals(martello.getNome(), borsa.removeAttrezzo("Martello").getNome());
		
		assertNull(borsa.removeAttrezzo("Pesante"));
		
	}
}























