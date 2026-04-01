package src.it.uniroma3.test;
import org.junit.jupiter.api.*;

import src.it.uniroma3.diadia.ambienti.Stanza;
import src.it.uniroma3.diadia.attrezzi.Attrezzo;

import static org.junit.jupiter.api.Assertions.*;

class StanzaTest {
	
	private Stanza prova1;
	private Stanza prova2;
	private Attrezzo martello;
	private Attrezzo cacciavite;

	@BeforeEach
	public void setUp() {
		prova1 = new Stanza("Prova 1");
		prova2 = new Stanza("Prova 2");
		martello = new Attrezzo("Martello", 5);
		cacciavite = new Attrezzo("Cacciavite", 1);
	}
	
	@Test
	public void testImpostaStanzaAdiacente() {
		prova1.impostaStanzaAdiacente("nord", prova2);
		assertEquals(prova2, prova1.getStanzaAdiacente("nord"));
		
		prova1.impostaStanzaAdiacente("est", prova2);
		assertEquals(prova2, prova1.getStanzaAdiacente("est"));
		
		prova1.impostaStanzaAdiacente("ovest", prova2);
		assertNotEquals(prova2, prova1.getStanzaAdiacente("sud"));
		
		prova1.impostaStanzaAdiacente("sud", prova2);
		assertEquals(prova2, prova1.getStanzaAdiacente("sud"));
		
		prova1.impostaStanzaAdiacente("sud-ovest", prova2);
		assertNotEquals(prova2, prova1.getStanzaAdiacente("sud-ovest"));
	}
	
	@Test
	public void testAddAttrezzo() {
		assertTrue(prova1.addAttrezzo(martello));
		
		assertTrue(prova1.addAttrezzo(cacciavite));
		
		for (int i = 2; i < 10; i ++) {
			prova1.addAttrezzo(martello);
		}
		assertFalse(prova1.addAttrezzo(cacciavite));
	}
	
	@Test
	public void testRemoveAttrezzo() {
		prova1.addAttrezzo(martello);
		
		assertEquals(martello.getNome(), prova1.removeAttrezzo("Martello").getNome());
		
		assertNull(prova1.removeAttrezzo("Cacciavite"));
		
		prova1.removeAttrezzo("Martello");
		assertFalse(prova1.hasAttrezzo("Martello"));
	}
	
	@Test
	public void testHasAttrezzo() {
		prova1.addAttrezzo(martello);
		assertTrue(prova1.hasAttrezzo("Martello"));
		
		assertFalse(prova1.hasAttrezzo("Cacciavite"));
		
		prova1.addAttrezzo(cacciavite);
		assertTrue(prova1.hasAttrezzo("Cacciavite"));
		
	}
}
