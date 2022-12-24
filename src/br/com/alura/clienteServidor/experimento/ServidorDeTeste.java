package br.com.alura.clienteServidor.experimento;

public class ServidorDeTeste {
//	cada threads tera uma cópia (cache), code smell
//	private boolean estaRodando = false;

//	as threads acessam o mesmo atribudo na memória principal
	private volatile boolean estaRodando = false;

	public static void main(String[] args) throws InterruptedException {
		ServidorDeTeste servidor = new ServidorDeTeste();
		servidor.rodar();
		servidor.alterandoAtributo();
	}

	private void rodar() {
		Thread thread = new Thread(new Runnable() {

			public void run() {
				System.out.println("Servidor começando, estaRodando = " + estaRodando);
				while (!estaRodando) {
				}

				if (estaRodando) {
					throw new RuntimeException("Deu erro na thread ...");
				}

				System.out.println("Servidor rodando, estaRodando = " + estaRodando);

				while (estaRodando) {
				}

				System.out.println("Servidor terminando, estaRodando = " + estaRodando);
			}
		});
		
		thread.setUncaughtExceptionHandler(new TratadorDeException());
		thread.start();
	}

	private void alterandoAtributo() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("Main alterando estaRodando = true");
		estaRodando = true;

		Thread.sleep(5000);
		System.out.println("Main alterando estaRodando = false");
		estaRodando = false;
	}
}
