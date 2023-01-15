package br.com.alura.clienteServidor.experimento;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TesteFila {

	public static void main(String[] args) throws InterruptedException {

		// fila não concorrente
		Queue<String> fila = new LinkedList<>();
				
		fila.offer("c1");
		fila.offer("c2");
		fila.offer("c3");
		
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.size());
		
		// fila concorrente
		BlockingQueue<String> filaConcorrente = new ArrayBlockingQueue<>(3);
		
		filaConcorrente.put("c1");
		filaConcorrente.put("c2");
		filaConcorrente.put("c3");
		
		System.out.println(filaConcorrente.take());
		System.out.println(filaConcorrente.take());
		System.out.println(filaConcorrente.take());
		System.out.println(filaConcorrente.size());
	}
}
