package controller;

public enum Bebida {

	COCA_COLA,
	DELRIO,
	SUCO_DO_CHAVES;
	
	public static Bebida tipoBebida(int numero)
	{
		return Bebida.values()[numero - 1];
	}
	
	public int getNumero()
	{
		return this.ordinal()+1;
	}
}
