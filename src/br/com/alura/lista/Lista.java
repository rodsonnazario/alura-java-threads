package br.com.alura.lista;

public class Lista {

	private String[] elementos = new String[Constantes.TAMANHO_LISTA];
	private int indice = 0;

	public synchronized void adicionaElementos(String elemento) {
		this.elementos[indice] = elemento;
		this.indice++;
		dorme(Constantes.TEMPO_PARA_ADICIONAR);
		notifica();
	}

	private void notifica() {
		if (estaCheia()) {
			System.out.println("lista cheia, notificando...");
			this.notify();
		}
	}

	private void dorme(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int tamanho() {
		return this.elementos.length;
	}

	public String pegaElemento(int posicao) {
		return this.elementos[posicao];
	}

	public boolean estaCheia() {
		return this.indice == this.elementos.length;
	}
}
