package br.com.alura.threads;

public class RespostaMain {

	public static void main(String[] args) {

		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("resposta");
			}
		}).start();
	}
}
