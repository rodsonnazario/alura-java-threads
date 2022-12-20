package br.com.alura.clienteServidor.servidor;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class DistribuirTarefas implements Runnable {

	private Socket socket;

	public DistribuirTarefas(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			System.out.println("Distribuindo tarefa para " + socket);
			Scanner entradaCliente = new Scanner(socket.getInputStream());
			PrintStream saidaCliente = new PrintStream(socket.getOutputStream());

			while (entradaCliente.hasNext()) {
				String comando = entradaCliente.nextLine();
				System.out.println("Comando recebido " + comando);

				switch (comando) {
					case "c1": {
						saidaCliente.println("Comando confirmado: " + comando);
						break;
					}
					case "c2": {
						saidaCliente.println("Comando confirmado: " + comando);
						break;
					}
					default: {
						saidaCliente.println("Comando não encontrado: " + comando);
					}
				}
			}
			entradaCliente.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
