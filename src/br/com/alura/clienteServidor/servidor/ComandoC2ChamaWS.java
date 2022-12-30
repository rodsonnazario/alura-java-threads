package br.com.alura.clienteServidor.servidor;

import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.Callable;

public class ComandoC2ChamaWS implements Callable<String> {

	private PrintStream saida;

	public ComandoC2ChamaWS(PrintStream saida) {
		this.saida = saida;
	}

	@Override
	public String call() throws Exception {
		System.out.println("Servidor recebeu comando c2 - WS");
		
		saida.println("Processando comando c2");

		Thread.sleep(5000);
		
		int numero = new Random().nextInt(100) + 1;

		saida.println("Servidor finalizou comando c2 - WS");
		return Integer.toString(numero);
	}
}
