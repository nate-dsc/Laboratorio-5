package controller;

public class Venda {

	private Cliente cliente;
	private CachorroQuente cachorrosQuente;
	
	public Venda(Cliente cliente, CachorroQuente c)
	{
		this.cliente = cliente;
		this.cachorrosQuente = c;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public CachorroQuente getCachorroQuente() {
		return this.cachorrosQuente;
	}
	
}
