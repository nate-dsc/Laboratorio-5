package controller;

public class Cliente {

	protected String nome;
	protected int ID;
	
	public Cliente(String nome, Integer ID)
	{
		this.nome = nome;
		this.ID = ID;
	}
	
	public String getNome()
	{
		return this.nome;
	}
	
	public int getID()
	{
		return this.ID;
	}
}
