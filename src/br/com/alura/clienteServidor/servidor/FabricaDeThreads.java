package br.com.alura.clienteServidor.servidor;

import java.util.concurrent.ThreadFactory;

public class FabricaDeThreads implements ThreadFactory {
	
	private static int numero = 1;

	@Override
	public Thread newThread(Runnable r) {
		
		Thread thread = new Thread(r, "Thread Servidor de Tarefas " + numero);
		numero++;
		thread.setUncaughtExceptionHandler(new TratadorDeException());		
		return thread;
	}

}
