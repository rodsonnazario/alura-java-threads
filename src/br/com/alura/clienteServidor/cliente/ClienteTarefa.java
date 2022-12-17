package br.com.alura.clienteServidor.cliente;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTarefa {

	public static void main(String[] args) throws Exception {

		Socket socket = new Socket("localhost", 12345);
		System.out.println("conexão estabelecida");

		PrintStream saida = new PrintStream(socket.getOutputStream());
		saida.println("c1");

		Scanner teclado = new Scanner(System.in);
		teclado.nextLine();

		saida.close();
		teclado.close();
		socket.close();
	}
}
