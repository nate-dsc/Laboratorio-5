package controller;

public enum Queijo {

	MUSSARELA,
	PRATO,
	PARMESAO,
	COALHO;
	
	public static Queijo tipoQueijo(int numero)
	{
		return Queijo.values()[numero - 1];
	}
	
	public int getNumero()
	{
		return this.ordinal()+1;
	}
}
