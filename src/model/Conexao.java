package model;

import java.sql.*;

public class Conexao 
{
	private String host;
	private String usuario;
	private String senha;
	private String banco;
	
	public Conexao()
	{
		this.host = "test_db.mysql.dbaas.com.br";
		this.banco = "test_db";
		this.usuario = "test_db";
		this.senha = "TecProg23-2!@";
	}
	
	public Connection getConexao()
	{
		String url = "jdbc:mysql://" + this.host + "/" + this.banco + "?enabledTLSProtocols=TLSv1.2&verifyServerCertificate=false&useSSL=true";
		try
		{
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conexao realizada");
			return conexao;
		}
		catch (SQLException e)
		{
			System.out.println("Conexao nao realizada");
			e.printStackTrace();
		}
		return null;
	}
}
