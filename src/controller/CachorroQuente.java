package controller;

public class CachorroQuente {

	protected Queijo queijo;
	protected Proteina proteina;
	protected String adicionais;
	protected Bebida bebida;
	protected double valor = 0f;
	
	public CachorroQuente(int queijo, int proteina, int bebida, String adicionais)
	{
		this.proteina = Proteina.tipoProteina(proteina);
		this.queijo = Queijo.tipoQueijo(queijo);
		this.bebida = Bebida.tipoBebida(bebida);
		this.adicionais = adicionais;
		setValor();
	}
	
	public void adicionarBebida(Bebida bebida)
	{
		this.bebida = bebida;
	}
	
	public String getAdicionais()
	{
		return adicionais;
	}
	
	public Proteina getProteina()
	{
		return proteina;
	}
	
	public Queijo getQueijo()
	{
		return queijo;
	}
	
	public Bebida getBebida()
	{
		return bebida;
	}
	
	public void setValor()
	{
		if(this.proteina.getNumero() == 1)
		{
			this.valor = 2.00;
		} else if(this.proteina.getNumero() == 2)
		{
			this.valor = 3.00;
		} else if(this.proteina.getNumero() == 3)
		{
			this.valor = 2.50;
		} else if(this.proteina.getNumero() == 4)
		{
			this.valor = 3.50;
		}
	}
	
	public double getValor()
	{
		return valor;
	}
}
