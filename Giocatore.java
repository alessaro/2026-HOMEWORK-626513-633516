package diadia;

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
		this.borsa.addAttrezzo(attrezzo);
		return eseguito;
	}
	
	public boolean removeAttrezzo(String nomeAttrezzo) {
		Attrezzo rimosso = this.borsa.removeAttrezzo(nomeAttrezzo);
		this.borsa.removeAttrezzo(nomeAttrezzo);
		return rimosso != null;
	}
	
	public void setCfu(int cfu) {
		this.cfu = cfu;
	}
	
	public int getCfu() {
		return this.cfu;
	}
}
