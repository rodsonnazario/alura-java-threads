package br.com.alura.banheiro;

public class Banheiro {
	
	private boolean isSujo = true;
	
	public void fazNumero1() {
		String nome = Thread.currentThread().getName();
		System.out.println(nome + " batendo na porta");
		
		synchronized (this) {
			System.out.println(nome + " entrando no banheiro");
			if (isSujo) {
				esperaLaFora(nome);
			}
			System.out.println(nome + " fazendo numero 1");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println(nome + " lavando as mãos");
			System.out.println(nome + " saindo do banheiro");	
		}
	}

	public void fazNumero2() {
		String nome = Thread.currentThread().getName();
		System.out.println(nome + " batendo na porta");
		
		synchronized (this) {
			System.out.println(nome + " entrando no banheiro");
			if (isSujo) {
				esperaLaFora(nome);
			}
			System.out.println(nome + " fazendo numero 2");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println(nome + " lavando as mãos");
			System.out.println(nome + " saindo do banheiro");	
		}
	}
	
	private void esperaLaFora(String nome) {
		System.out.println(nome + ", eca, banheiro está sujo");
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
