package br.com.alura.lista;

import java.util.List;

public class TarefaImprimirLista implements Runnable {

	private List<String> lista;

	public TarefaImprimirLista(List<String> lista) {
		this.lista = lista;
	}

	@Override
	public void run() {
		synchronized (lista) {
			System.out.println("esperando... (lista)");
			dorme(Constantes.TEMPO_TOTAL);
			System.out.println("lista cheia...");
			for (int i = 0; i < lista.size(); i++) {
				System.out.println(i + " - " + lista.get(i));
			}
		}
	}

	private void dorme(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
