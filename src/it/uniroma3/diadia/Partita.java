package src.it.uniroma3.diadia;

import src.it.uniroma3.diadia.ambienti.Labirinto;
import src.it.uniroma3.diadia.ambienti.Stanza;
import src.it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {
	private Stanza stanzaCorrente;
	private boolean finita;
	private Labirinto labirinto;
	private Giocatore player;
	
	public Partita(){
		labirinto = new Labirinto();
		player = new Giocatore();
		this.finita = false;

		setStanzaCorrente(labirinto.getEntrata());
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente() == this.labirinto.getUscita();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.player.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	public Giocatore getPlayer() {
		return this.player;
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
}
