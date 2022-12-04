package br.com.alura.threads.buscaTextual;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TarefaBuscaTextual implements Runnable {

	private String nomeArquivo;
	private String nome;
	private final String PATH = "src/br/com/alura/threads/buscaTextual/";

	public TarefaBuscaTextual(String nomeArquivo, String nome) {
		this.nomeArquivo = nomeArquivo;
		this.nome = nome;
	}

	@Override
	public void run() {
		try {
			Scanner scanner = new Scanner(new File(PATH + nomeArquivo));
			int numeroLinha = 1;
			while (scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				if (linha.toLowerCase().contains(nome.toLowerCase())) {
					System.out.println(nomeArquivo + " - " + numeroLinha + " - " + linha);
				}
				numeroLinha++;
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
