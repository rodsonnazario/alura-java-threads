package br.com.alura.clienteServidor.servidor;

import java.io.PrintStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class JuntaResultadoFutureWSFutureBanco implements Callable<Void> {

	private Future<String> futureWS;
	private Future<String> futureBanco;
	private PrintStream saidaCliente;

	public JuntaResultadoFutureWSFutureBanco(
			Future<String> futureWS, 
			Future<String> futureBanco,
			PrintStream saidaCliente) {
				this.futureWS = futureWS;
				this.futureBanco = futureBanco;
				this.saidaCliente = saidaCliente;
	}

	@Override
	public Void call() {
		
		System.out.println("Aguardando resultado do future WS e Banco");
		
		try {
			String resultWS = this.futureWS.get(5, TimeUnit.SECONDS);
			String resultBanco = this.futureBanco.get(5, TimeUnit.SECONDS);
			
			this.saidaCliente.println("Resultado comando c2: " + resultWS + ", " + resultBanco);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			System.out.println("Timeout: cancelando execução do comando c2");
			this.saidaCliente.println("Timeout na execução do comando c2");
			this.futureWS.cancel(true);
			this.futureBanco.cancel(true);
		}
		
		System.out.println("Finalizou JuntaResultadoFutureWSFutureBanco");
		
		return null;
	}
}
