package br.com.inatel;

public class mainAv {
	
	public static void main(String[] args) {
		Arquivo arq = new Arquivo();
		
		Plataforma p = new Plataforma("Steam", "UM CORNO FDP MERDA DO CARALHO");
		arq.escrever(p);
		
		Jogo j1 = new Jogo("CS", "FPS", 60.0, true);
		Jogo j2 = new Jogo("Rocket League", "Futebol", 20.0, true);
		Jogo j3 = new Jogo("Rust", "Sobrevivencia", 80.0, true);
		Jogo j4 = new Jogo("Dota 2", "MOBA", 0.0, false);
			
		p.addJogo(j1);
		p.addJogo(j2);
		p.addJogo(j3);
		p.addJogo(j4);
		p.escrever();
		
		Plataforma p2 = new Plataforma("Origin", "Um sem nada");
		arq.escrever(p2);
		
		Jogo j12 = new Jogo("Fifa", "Futebol", 300.0, true);
		Jogo j22 = new Jogo("Battlefield", "FPS", 180.0, true);
		Jogo j32 = new Jogo("Pes", "Futebol", 250.0, false);
		Jogo j42 = new Jogo("Jogo Qualquer", "MOBA", 290.0, false);
		
		p2.addJogo(j12);
		p2.addJogo(j22);
		p2.addJogo(j32);
		p2.addJogo(j42);
		p2.escrever();
		
		Awards aw = new Awards("Summer Awards");
		aw.addPlataforma(p);
		aw.addPlataforma(p2);
		aw.mostraCategorias();
	}
}
