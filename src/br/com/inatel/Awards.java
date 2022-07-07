package br.com.inatel;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Awards {
	
	private String nome;
	
	public Awards(String nome) {
		this.nome = nome;
	}

	private ArrayList<Plataforma> plataformas = new ArrayList<Plataforma>();
	
	public void addPlataforma(Plataforma plataforma) {
		plataformas.add(plataforma);
	}
	
	public void mostraCategorias() {
		System.out.println("Premiacao: " + this.nome);
		System.out.println("Mais DLCs: " + plataformaComMaisDLCs());
		System.out.println("Mais Caro: " + plataformaJogoMaisCaro());
		System.out.println("Mais Barato: " + plataformaJogoMaisBarato());
		System.out.print("Mais Jogos: ");
		plataformaMaisJogos().forEach(p -> System.out.print(p.getNome() + " "));
		System.out.println("\nPlataforma ganhadora: " + plataformaMaisPontos());
	}
	
	private Stream<Plataforma> plataformaMaisJogos() {
		Plataforma p = plataformas.stream()
				.max((p1,p2) -> Integer.compare(p1.getJogos().size(), p2.getJogos().size()))
				.get();
		
		Stream<Plataforma> sP = plataformas.stream()
				.filter(plat -> plat.getJogos().size() == p.getJogos().size());
		
		
		return plataformas.stream()
				.filter(plat -> plat.getJogos().size() == p.getJogos().size());
	}

	private String plataformaComMaisDLCs() {
		Plataforma p = plataformas.stream()
			.max((p1, p2) -> Integer.compare(p1.calculaDlc(), p2.calculaDlc()))
			.get();
		
		p.ganhaPontos();
		return p.getNome();
	}
	
	private String plataformaJogoMaisCaro() {
		Plataforma p = plataformas.stream()
			.max((p1, p2) -> Double.compare(p1.getJogoMaisCaro(), p2.getJogoMaisCaro()))
			.get();
		
		p.ganhaPontos();
		return p.getNome();
	}
	
	private String plataformaJogoMaisBarato() {
		Plataforma p = plataformas.stream()
			.min((p1, p2) -> Double.compare(p1.getJogoMaisBarato(), p2.getJogoMaisBarato()))
			.get();
		
		p.ganhaPontos();
		return p.getNome();
	}
	
	private String plataformaMaisPontos() {
		Plataforma p = plataformas.stream()
			.max((p1, p2) -> Integer.compare(p1.getPontuacao(), p2.getPontuacao()))
			.get();
		
		return p.getNome();
	}
	
}
