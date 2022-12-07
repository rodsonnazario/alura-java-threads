package br.com.alura.lista;

import java.util.List;
import java.util.Vector;

public class Principal {

	public static void main(String[] args) throws InterruptedException {

		Lista listaManual = new Lista();
		List<String> lista = new Vector<String>();

		for (int i = 0; i < 10; i++) {
			Thread thread1 = new Thread(new TarefaAdicionaElemento(lista, i));
			Thread thread2 = new Thread(new TarefaAdicionaElementoManual(listaManual, i));
			thread1.start();
			thread2.start();
		}

		Thread.sleep(2000);

		System.out.println("THREAD COM LISTA MANUAL");
		for (int i = 0; i < listaManual.tamanho(); i++) {
			System.out.println(i + " - " + listaManual.pegaElemento(i));
		}

		System.out.println("THREAD COM LISTA DO JAVA");
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(i + " - " + lista.get(i));
		}
	}
}
