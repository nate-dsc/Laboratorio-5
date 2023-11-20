package controller;

public enum Proteina {

	SALSICHA,
	LINGUICA,
	FRANGO,
	BACON;

	public static Proteina tipoProteina(int id)
	{
		return Proteina.values()[id - 1];
	}
	
	public int getNumero()
	{
		return this.ordinal()+1;
	}
}
