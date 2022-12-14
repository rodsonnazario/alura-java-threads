package br.com.alura.lista;

public class Constantes {
	
	public static int THREADS = 10;
	public static int ELEMENTOS_POR_THREAD = 100;
	public static int TEMPO_PARA_ADICIONAR = 5;
	
	public static int TAMANHO_LISTA = THREADS * ELEMENTOS_POR_THREAD;
	public static int TEMPO_TOTAL = TAMANHO_LISTA * TEMPO_PARA_ADICIONAR;

}
