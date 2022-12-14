package br.com.alura.lista;

public class TarefaImprimirListaCustomizada implements Runnable {

	private Lista lista;

	public TarefaImprimirListaCustomizada(Lista lista) {
		this.lista = lista;
	}

	@Override
	public void run() {
		synchronized (lista) {
			if(!lista.estaCheia() ) {				
				System.out.println("esperando notificação... (listaManual)");
				espera();
			}
			for (int i = 0; i < lista.tamanho(); i++) {
				System.out.println(i + " - " + lista.pegaElemento(i));
			}
		}
	}

	private void espera() {
		try {
			lista.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
