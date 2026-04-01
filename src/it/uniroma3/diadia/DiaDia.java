package src.it.uniroma3.diadia;

import java.util.Scanner;

import src.it.uniroma3.diadia.ambienti.Stanza;
import src.it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "posa", "prendi"};

	private Partita partita;

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca(IOConsole io) {
		String istruzione;
		
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		io.mostraMessaggio("\n" + "Ti trovi nel: " + partita.getStanzaCorrente().getDescrizione());

		do		
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione, io));
		
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione, IOConsole io) {
		Comando comandoDaEseguire = new Comando(istruzione);
		
		if (comandoDaEseguire.getNome().equals(null)) {
			io.mostraMessaggio("Comando sconosiuto");
			return false;
		}

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(io); 
			return true;
		}
		
		else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro(), io);
		
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto(io);
		
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro(), io);
		
		else if(comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro(), io);
		
		else
			io.mostraMessaggio("Comando sconosiuto");
		
		if (this.partita.isFinita()) {	// Modificato: non teneva conto della perdita di cfu ad ogni sposatmento
			io.mostraMessaggio("La partita è terminata\n");
			if (this.partita.vinta()) {io.mostraMessaggio("Hai vinto !");}
			else {io.mostraMessaggio("Hai terminato i CFU e hai perso, ritenta!");}
			return true;
		} 
		
		else
			return false;
	}   

	// implementazioni dei comandi dell'utente:
	
	private void prendi (String nomeAttrezzo, IOConsole io) {
		if (nomeAttrezzo.equals("")) {
			io.mostraMessaggio("Inserisci un attrezzo valido\n");
			return;
		}
		Attrezzo att = this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if (att == null) { io.mostraMessaggio("Attrezzo inesistente"); }
		
		else if (att != null && this.partita.getPlayer().addAttrezzo(att)) {
			this.partita.getStanzaCorrente().removeAttrezzo(nomeAttrezzo);
			this.partita.getPlayer().addAttrezzo(att);
			io.mostraMessaggio(nomeAttrezzo + " preso\n");
		}
		else io.mostraMessaggio("Impossibile prendere l'oggetto\n");
	}
	
	private void posa (String nomeAttrezzo, IOConsole io) {
		if (nomeAttrezzo.equals("")) {
			io.mostraMessaggio("Inserisci un attrezzo valido\n");
			return;
		}
		Attrezzo att = this.partita.getPlayer().getBorsa().getAttrezzo(nomeAttrezzo);
		if (att != null && this.partita.getStanzaCorrente().addAttrezzo(att)) {
			this.partita.getPlayer().removeAttrezzo(nomeAttrezzo);
			this.partita.getStanzaCorrente().addAttrezzo(att);
			io.mostraMessaggio(nomeAttrezzo + " posato\n");
		}
		else io.mostraMessaggio("Impossibile posare l'oggetto\n");
	}

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto(IOConsole io) {
		for(int i = 0; i < elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i] + "\n");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai (String direzione, IOConsole io) {
		if(direzione == null) {
			io.mostraMessaggio("Dove vuoi andare ?\n");
			return;
		}
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getPlayer().getCfu();
			this.partita.getPlayer().setCfu(cfu-=1);
			io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		}
	}

	/**
	 * Comando "Fine".
	 */
	private void fine(IOConsole io) {
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		IOConsole io = new IOConsole();

		gioco.gioca(io);
	}
}