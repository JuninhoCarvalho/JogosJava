package br.com.inatel;

public class Jogo {
	
	private String nome;
	private String genero;
	private Double preco;
	private boolean caro;
	private boolean barato;
	private boolean dlc;
	
	public Jogo(String nome, String genero, Double preco, boolean dlc) {
		this.nome = nome;
		this.genero = genero;
		this.preco = preco;
		this.dlc = dlc;
	}

	public void mostraInfo() {
		System.out.println("------Jogo------");
		System.out.println("Nome: " + this.nome);
		System.out.println("Genero: " + this.genero);
		System.out.println("Preco: " + this.preco);
		System.out.println("DLC? " + this.dlc);
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public Double getPreco() {
		return preco;
	}
	
	public boolean getDlc() {
		return dlc;
	}
	
	public boolean isCaro() {
		return caro;
	}
	
	public boolean isBarato() {
		return barato;
	}
	
	public void setCaro(boolean caro) {
		this.caro = caro;
	}
	
	public void setBarato(boolean barato) {
		this.barato = barato;
	}
}
