package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.CachorroQuente;
import controller.Cliente;
import controller.Venda;

public class VendasDAO
{
	public ArrayList<Venda> getTodasVendas()
	{
		ArrayList<Venda> vendas = new ArrayList<Venda>();
		
		try
		{
			Connection conexao = new Conexao().getConexao();
			String query = "select * from aluno order by id_cachorro_quente asc";
			ResultSet dados = conexao.prepareStatement(query).executeQuery();
			
			while(dados.next())
			{
				String nome = dados.getString("nome");
				int matricula = dados.getInt("matricula");
				Cliente cliente = new Cliente(nome, matricula);
				int proteina = dados.getInt("op_proteina");
				int queijo = dados.getInt("op_queijo");
				int bebida = dados.getInt("bebida");
				String adicionais = dados.getString("ingredientes");
				CachorroQuente c = new CachorroQuente(proteina, queijo, bebida, adicionais);
				Venda venda = new Venda(cliente, c);
				vendas.add(venda);
			}
			conexao.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return vendas;
	}
	
	public void inserir(Venda v)
	{
		try
		{
			Connection conexao = new Conexao().getConexao();
			PreparedStatement inserir = conexao.prepareStatement("INSERT INTO cachorro_quente (nome, matricula, op_queijo, op_proteina, ingredientes, bebida, valor) VALUES (?, ?, ?, ?, ?, ?, ?)");
			inserir.setString(1, v.getCliente().getNome());
			inserir.setInt(2, v.getCliente().getID());
			inserir.setInt(3, v.getCachorroQuente().getQueijo().getNumero());
			inserir.setInt(4, v.getCachorroQuente().getProteina().getNumero());
			inserir.setString(5, v.getCachorroQuente().getAdicionais());
			inserir.setInt(6, v.getCachorroQuente().getBebida().getNumero());
			inserir.setDouble(7, v.getCachorroQuente().getValor());
			inserir.execute();
			conexao.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
