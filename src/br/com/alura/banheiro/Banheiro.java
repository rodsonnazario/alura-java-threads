package br.com.alura.banheiro;

public class Banheiro {

	private boolean isSujo = true;

	public void fazNumero1() {
		String nome = Thread.currentThread().getName();
		System.out.println(nome + " batendo na porta");

		synchronized (this) {
			System.out.println(nome + " entrando no banheiro");
			while (isSujo) {
				esperaLaFora(nome);
			}
			System.out.println(nome + " fazendo numero 1");
			espera(5000);
			this.isSujo = true;
			System.out.println(nome + " lavando as mãos");
			System.out.println(nome + " saindo do banheiro");
		}
	}

	public void fazNumero2() {
		String nome = Thread.currentThread().getName();
		System.out.println(nome + " batendo na porta");

		synchronized (this) {
			System.out.println(nome + " entrando no banheiro");
			while (isSujo) {
				esperaLaFora(nome);
			}
			System.out.println(nome + " fazendo numero 2");
			espera(5000);
			this.isSujo = true;
			System.out.println(nome + " lavando as mãos");
			System.out.println(nome + " saindo do banheiro");
		}
	}

	public void limpa() {
		String nome = Thread.currentThread().getName();
		System.out.println(nome + " batendo na porta");

		synchronized (this) {
			System.out.println(nome + " entrando no banheiro");
			if (!isSujo) {
				System.out.println(nome + " não está sujo, vou sair");
				return;
			}
			System.out.println(nome + " limpando o banheiro");
			isSujo = false;
			espera(5000);
			this.notifyAll();
			System.out.println(nome + " saindo do banheiro");
		}
	}

	private void espera(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	private void esperaLaFora(String nome) {
		System.out.println(nome + " eca, banheiro está sujo");
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
