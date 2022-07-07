package br.com.inatel;

import java.util.ArrayList;

public class Plataforma {
	
	private String nome;
	private String criador;
	private ArrayList<Jogo> jogos = new ArrayList<>();
	private Integer pontuacao;
	private Double jogoMaisCaro;
	private Double jogoMaisBarato;
	Arquivo arq = new Arquivo();
	
	public Plataforma(String nome, String criador) {
		this.nome = nome;
		this.criador = criador;
		this.pontuacao = 0;
	}
	
	public void addJogo(Jogo jogo) {
		jogos.add(jogo);
		if(jogo == maisBarato()) {
			jogo.setBarato(true);
			jogos.stream()
				.filter(j -> j.getNome() != jogo.getNome())
				.filter(j -> j.isBarato())
				.forEach(j -> j.setBarato(false));
			jogoMaisBarato = jogo.getPreco();
		}
		
		if(jogo == maisCaro()) {
			jogo.setCaro(true);
			jogos.stream()
				.filter(j -> j.getNome() != jogo.getNome())
				.filter(j -> j.isCaro())
				.forEach(j -> j.setCaro(false));
			jogoMaisCaro = jogo.getPreco();
		}
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCriador() {
		return criador;
	}
	
	public void mostraInfo() {
		System.out.println("------Plataforma------");
		System.out.println("Nome: " + this.nome);
		System.out.println("Criador: " + this.criador);
		jogos.forEach(j -> j.mostraInfo());
	}
	
	public Jogo maisBarato() {
		return jogos.stream()
			.min((j1, j2) -> Double.compare(j1.getPreco(), j2.getPreco()))
			.get();
	}
	
	public Jogo maisCaro() {
		return jogos.stream()
				.max((j1, j2) -> Double.compare(j1.getPreco(), j2.getPreco()))
				.get();
	}
	
	public int calculaDlc() {		
		int qtd = (int) jogos.stream()
			.filter(j -> j.getDlc()==true)
			.count();
		
		return qtd;
	}
	
	public void escrever() {
		arq.escrever(jogos);
	}
	
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	public int getPontuacao() {
		return pontuacao;
	}
	
	public Double getJogoMaisBarato() {
		return jogoMaisBarato;
	}
	
	public Double getJogoMaisCaro() {
		return jogoMaisCaro;
	}

	public void ganhaPontos() {
		setPontuacao(getPontuacao()+1);
	}
	
	public ArrayList<Jogo> getJogos() {
		return jogos;
	}
}
