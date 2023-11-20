package view;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controller.Barraquinha;

public class Janela extends JFrame {

	private Barraquinha barraquinha;
	
	public static final Color VERDE_CLARO = new Color(217, 234, 211);
	public static final Color AZUL = new Color(201, 218, 248);
	public static final Color AZUL_CLARO = new Color(207, 226, 243);
	public static final Color AZUL_ESCURO = new Color(109, 158, 235);
	
	public static final Dimension TAMANHO_BAIXO = new Dimension(595, 550);
	public static final Dimension TAMANHO_PAINEL_PEQUENO = new Dimension(74, 520);
	
	CardLayout cardLayout = new CardLayout();
	
	JPanel painelBaixo = new JPanel();
	JPanel painelTopo = new JPanel();
	
	public Janela(Barraquinha barraquinha)
	{
		this.barraquinha = barraquinha;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout(0, 5));
		criarPainelTopo();
		criarPainelBaixo();
		add(painelTopo, BorderLayout.NORTH);
		add(painelBaixo, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	private class BotaoRV extends JButton implements ActionListener
	{
		BotaoRV()
		{
			setText("Realizar Venda");
			setPreferredSize(new Dimension(135,40));
			addActionListener(this);
			setBackground(VERDE_CLARO);
			setFocusable(false);
		}

		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == this)
			{
				System.out.println("RV");
				cardLayout.show(painelBaixo, "RV");
			}
		}
	}
	
	private class BotaoLV extends JButton implements ActionListener
	{
		BotaoLV()
		{
			setText("Listar Vendas");
			setPreferredSize(new Dimension(135,40));
			addActionListener(this);
			setBackground(VERDE_CLARO);
			setFocusable(false);
		}

		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == this)
			{
				System.out.println("LV");
				cardLayout.show(painelBaixo, "LV");
			}
		}
	}
	
	private class BotaoMR extends JButton implements ActionListener
	{
		BotaoMR()
		{
			setText("Mostrar Relatório");
			setPreferredSize(new Dimension(135,40));
			addActionListener(this);
			setBackground(VERDE_CLARO);
			setFocusable(false);
		}

		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == this)
			{
				System.out.println("MR");
			}
		}
	}
	
	private class BotaoLC extends JButton implements ActionListener
	{
		BotaoLC()
		{
			setText("Listar Clientes");
			setPreferredSize(new Dimension(135,40));
			addActionListener(this);
			setBackground(VERDE_CLARO);
			setFocusable(false);
		}

		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == this)
			{
				System.out.println("LC");
			}
		}
	}

	private void criarPainelTopo()
	{
		painelTopo.setSize(600, 50);
		painelTopo.add(new BotaoRV());
		painelTopo.add(new BotaoLV());
		painelTopo.add(new BotaoMR());
		painelTopo.add(new BotaoLC());
		painelTopo.setBackground(AZUL);
		painelTopo.setLayout(new FlowLayout(FlowLayout.CENTER));
	}
	
	private void criarPainelBaixo()
	{
		painelBaixo.setSize(TAMANHO_BAIXO);
		painelBaixo.setBackground(AZUL);
		painelBaixo.setLayout(cardLayout);
		painelBaixo.add(new RealizarVendas(this), "RV");
		painelBaixo.add(new ListarVendas(this), "LV");
		cardLayout.show(painelBaixo, "RV");
		
	}
	
	private void criarPainelRealizarVenda()
	{
		painelBaixo.setSize(TAMANHO_BAIXO);
		painelBaixo.setBackground(AZUL);
		
		painelBaixo.setLayout(new GridLayout(8, 2));
			
		JLabel nomeClienteTxt = new JLabel("Nome do Cliente");
		painelBaixo.add(nomeClienteTxt);
		
		JTextField nomeClienteTF = new JTextField();
		nomeClienteTF.setBackground(AZUL_CLARO);
		painelBaixo.add(nomeClienteTF);
	}
	
	private void criarPainelListarVendas()
	{
		painelBaixo.setSize(TAMANHO_BAIXO);
		painelBaixo.setBackground(AZUL);
	}
	
	public boolean receberVenda(String vendaFormatada)
	{
		boolean resultado = barraquinha.validarVenda(vendaFormatada);
		return resultado;
	}
}
