package br.com.alura.banco;

public class TarefaAcessoBanco implements Runnable {

	private PoolDeConexao pool;
	private GerenciadorDeTransacao tx;

	public TarefaAcessoBanco(PoolDeConexao pool, GerenciadorDeTransacao tx) {
		this.pool = pool;
		this.tx = tx;
	}

	@Override
	public void run() {
		synchronized (pool) {
			System.out.println("Pega conexão");
			pool.getConnection();

			synchronized (tx) {
				System.out.println("Inicia transação");
				tx.begin();
			}
		}
	}
}
