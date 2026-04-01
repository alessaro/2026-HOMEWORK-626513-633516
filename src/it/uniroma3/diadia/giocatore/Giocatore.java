package src.it.uniroma3.diadia.giocatore;

import src.it.uniroma3.diadia.attrezzi.Attrezzo;

public class Giocatore {
	private final int CFU_INIZIALI = 20;
	private Borsa borsa;
	private int cfu;
	
	public Giocatore() {
		this.borsa = new Borsa();
		this.cfu = CFU_INIZIALI;
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		boolean eseguito = this.borsa.addAttrezzo(attrezzo);
		if (eseguito == true) {
			this.borsa.addAttrezzo(attrezzo);
			return true;
		}		
		return false;
	}
	
	public boolean removeAttrezzo(String nomeAttrezzo) {
		Attrezzo rimosso = this.borsa.removeAttrezzo(nomeAttrezzo);
		if (rimosso != null) {
			this.borsa.removeAttrezzo(nomeAttrezzo);
			return true;
		}
		return false;
	}
	
	public void setCfu(int cfu) {
		this.cfu = cfu;
	}
	
	public int getCfu() {
		return this.cfu;
	}
	
	public Borsa getBorsa() {
		return this.borsa;
	}
}
