package br.com.alura.lista;

import java.util.List;
import java.util.Vector;

public class Principal {

	public static void main(String[] args) throws InterruptedException {

		Lista listaCustomizada = new Lista();
		List<String> lista = new Vector<String>();

		for (int i = 0; i < Constantes.THREADS; i++) {
			Thread thread1 = new Thread(new TarefaAdicionaElemento(lista, i));
			Thread thread2 = new Thread(new TarefaAdicionaElementoCustomizado(listaCustomizada, i));
			thread1.start();
			thread2.start();
		}
		
		new Thread(new TarefaImprimirLista(lista)).start();
		new Thread(new TarefaImprimirListaCustomizada(listaCustomizada)).start();
	}
}
