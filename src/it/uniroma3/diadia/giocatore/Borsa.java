package src.it.uniroma3.diadia.giocatore;

import src.it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
			this.pesoMax = pesoMax;
			this.attrezzi = new Attrezzo[10];
			this.numeroAttrezzi = 0;
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi >= 10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}
	
	public int getPesoMax() {
			return pesoMax;
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		for(Attrezzo att : this.attrezzi)
			if (att != null && att.getNome().equals(nomeAttrezzo)) {return att;}
		return null;
	}
	
	public int getPeso() {
		int peso = 0;
		for (int i = 0; i < this.numeroAttrezzi; i++)
			if (this.attrezzi[i] != null) { peso += this.attrezzi[i].getPeso(); }
		return peso;
		}
	
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
		
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo) != null;
	}
		
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		int count = 0;
		for (Attrezzo attrezzo : this.attrezzi) {
			if (attrezzo != null && attrezzo.getNome().equals(nomeAttrezzo)) {
				this.attrezzi[count] = null;
				this.numeroAttrezzi -= 1;
				return attrezzo;
			}
			count ++;
		}
		return null;
	}
		
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString()+" ");
		}		
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}