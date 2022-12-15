package br.com.alura.banco;

public class TarefaAcessoBancoProcedimento implements Runnable {

	private PoolDeConexao pool;
	private GerenciadorDeTransacao tx;

	public TarefaAcessoBancoProcedimento(PoolDeConexao pool, GerenciadorDeTransacao tx) {
		this.pool = pool;
		this.tx = tx;
	}

	@Override
	public void run() {
		synchronized (tx) {
			System.out.println("Inicia transação (procedimento)");
			tx.begin();

			synchronized (pool) {
				System.out.println("Pega conexão (procedimento)");
				pool.getConnection();
			}
		}
	}

}
