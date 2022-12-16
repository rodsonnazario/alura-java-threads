package br.com.alura.clienteServidor.cliente;

import java.net.Socket;

public class ClienteTarefa {

	public static void main(String[] args) throws Exception {

		Socket socket = new Socket("localhost", 12345);
		System.out.println("conexão estabelecida");
		socket.close();
	}
}
