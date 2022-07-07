package br.com.inatel;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Arquivo {

	public void escrever(ArrayList<Jogo> jogos) {
		OutputStream os = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		
		try {
			os = new FileOutputStream("arquivoJogos.txt", true);
			osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);
			
			for (int i = 0; i < jogos.size(); i++) {
				if(jogos.get(i).isCaro())
					bw.write("----Jogo---- <- Mais Caro\n");
				else if(jogos.get(i).isBarato())
					bw.write("----Jogo---- <- Mais Barato\n");
				else
					bw.write("----Jogo----\n");
				bw.write(jogos.get(i).getNome() + "\n");
				bw.write(jogos.get(i).getGenero() + "\n");
				bw.write(jogos.get(i).getPreco() + "\n");
				bw.write(jogos.get(i).getDlc() + "\n");
			}
			

		} catch (Exception e) {
			System.out.println(e);

		} finally {
			try {
				bw.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	public void escrever(Plataforma p) {
		OutputStream os = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		
		try {
			os = new FileOutputStream("arquivoJogos.txt", true);
			osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);

			bw.write("----Plataforma----");
			bw.newLine();
			bw.write(p.getNome() + "\n");
			bw.write(p.getCriador() + "\n");

		} catch (Exception e) {
			System.out.println(e);

		} finally {
			try {
				bw.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
