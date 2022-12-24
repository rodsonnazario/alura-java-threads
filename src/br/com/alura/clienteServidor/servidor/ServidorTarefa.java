package br.com.alura.clienteServidor.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServidorTarefa {

	private ServerSocket servidor;
	private ExecutorService threadPool;
	private AtomicBoolean executando;

	public ServidorTarefa() throws IOException {
		System.out.println("--- Iniciando servidor ---");
		this.servidor = new ServerSocket(12345);
//		this.threadPool = Executors.newCachedThreadPool();
		this.threadPool = Executors.newFixedThreadPool(4, new FabricaDeThreads());
		this.executando = new AtomicBoolean(true);
	}

	public void executar() throws IOException {
		while (executando.get()) {
			try {
				Socket socket = servidor.accept();
				System.out.println("Aceitando novo cliente na porta " + socket.getPort());
				DistribuirTarefas distribuirTarefas = new DistribuirTarefas(threadPool, socket, this);
				threadPool.execute(distribuirTarefas);
			} catch (SocketException e) {
				System.out.println("SocketException, está rodando? " + this.executando);
			}
		}
	}
	
	public void parar() throws IOException {
		executando.set(false);
		servidor.close();
		threadPool.shutdown();
	}
	
	public static void main(String[] args) throws Exception {
		ServidorTarefa servidor = new ServidorTarefa();
		servidor.executar();
		servidor.parar();
	}
}
