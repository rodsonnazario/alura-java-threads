package br.com.alura.lista;

public class TarefaAdicionaElementoCustomizado implements Runnable {

	private Lista lista;
	private int numeroDaThread;

	public TarefaAdicionaElementoCustomizado(Lista lista, int numeroDaThread) {
		this.lista = lista;
		this.numeroDaThread = numeroDaThread;
	}

	@Override
	public void run() {
		for (int i = 0; i < Constantes.ELEMENTOS_POR_THREAD; i++) {
			lista.adicionaElementos("Thread " + numeroDaThread + " - " + i);
		}
	}
}
