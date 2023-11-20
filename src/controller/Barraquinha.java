package controller;

import model.Banco;

public class Barraquinha {

	private Banco banco;
	
	public Barraquinha()
	{
		this.banco = new Banco();
	}
	
	public boolean validarVenda(String vendaString)
	{
		boolean valido = true;
		String[] dados = vendaString.split(";");
		
		if(dados[0].equals(""))
		{
			valido = false;
		}
		
		try
		{
			if(Integer.valueOf(dados[1]) < 0)
			{
				valido = false;
			}
		} catch (NumberFormatException e)
		{
			valido = false;
		}
		
		if(Integer.valueOf(dados[2]) <= 0)
		{
			valido = false;
		}
		else if(Integer.valueOf(dados[3]) <= 0)
		{
			valido = false;
		}
		else if(Integer.valueOf(dados[4]) <= 0)
		{
			valido = false;
		}
		else if(valido == true)
		{
			banco.registrarNoBanco(strToVenda(vendaString));
		}
		return valido;
	}
	
	private Venda strToVenda(String vendaString)
	{
		String[] dados = formatarDados(vendaString.split(";"));
		String nome = dados[0];
		int matricula = Integer.parseInt(dados[1]);
		Cliente cliente = new Cliente(nome, matricula);
		int proteina = Integer.parseInt(dados[2]);
		int queijo = Integer.parseInt(dados[3]);
		int bebida = Integer.parseInt(dados[4]);
		String adicionais = dados[5];
		CachorroQuente c = new CachorroQuente(proteina, queijo, bebida, adicionais);
		Venda venda = new Venda(cliente, c);
		return venda;
	}
	
	private String[] formatarDados(String[] dados)
	{
		String[] dadosFormatados = new String[6];
		
		if(dados[5].equals("true"))
			dados[5] = "KETCHUP, ";
		else
			dados[5] = "";
		
		if(dados[6].equals("true"))
			dados[6] = "MAIONESE, ";
		else
			dados[6] = "";
		
		if(dados[7].equals("true"))
			dados[7] = "OVO, ";
		else
			dados[7] = "";
		
		if(dados[8].equals("true"))
			dados[8] = "BATATA, ";
		else
			dados[8] = "";
		
		dadosFormatados[0] = dados[0];
		dadosFormatados[1] = dados[1];
		dadosFormatados[2] = dados[2];
		dadosFormatados[3] = dados[3];
		dadosFormatados[4] = dados[4];
		dadosFormatados[5] = dados[5] + dados[6] + dados[7] + dados[8];
		return dadosFormatados;
	}
}
