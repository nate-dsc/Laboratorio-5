package model;

import controller.Venda;

public class Banco {

	private VendasDAO vendasDAO;
	
	public Banco()
	{
		vendasDAO = new VendasDAO();
	}
	
	public void registrarNoBanco(Venda v)
	{
		vendasDAO.inserir(v);
	}
}
