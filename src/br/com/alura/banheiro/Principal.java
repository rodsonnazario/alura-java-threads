package br.com.alura.banheiro;

public class Principal {

	public static void main(String[] args) {

		Banheiro banheiro = new Banheiro();

		Thread convidado1 = new Thread(new TarefaNumero1(banheiro), "João");
		Thread convidado2 = new Thread(new TarefaNumero2(banheiro), "Pedro");
		Thread limpeza = new Thread(new TarefaLimpeza(banheiro), "Funcionário");
		Thread convidado3 = new Thread(new TarefaNumero1(banheiro), "Maria");
		Thread convidado4 = new Thread(new TarefaNumero2(banheiro), "Ana");

		convidado1.start();
		convidado2.start();
		limpeza.start();
		convidado3.start();
		convidado4.start();
	}
}
