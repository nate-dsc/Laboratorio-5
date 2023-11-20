package view;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Painel extends JPanel {

	Painel(Component componente)
	{
		this.setBackground(Janela.AZUL);
		this.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
		this.setLayout(new BorderLayout());
		this.add(componente, BorderLayout.CENTER);
	}
	
	Painel(String texto)
	{
		this.setBackground(Janela.AZUL);
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.setLayout(new FlowLayout(FlowLayout.LEADING));
		this.add(new JLabel(texto));
	}
	
	Painel(JCheckBox caixa1, JCheckBox caixa2, JCheckBox caixa3, JCheckBox caixa4)
	{
		this.setBackground(Janela.AZUL);
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.setLayout(new GridLayout(2, 2));
		caixa1.setBackground(Janela.AZUL);
		this.add(caixa1);
		caixa2.setBackground(Janela.AZUL);
		this.add(caixa2);
		caixa3.setBackground(Janela.AZUL);
		this.add(caixa3);
		caixa4.setBackground(Janela.AZUL);
		this.add(caixa4);
	}
	
	Painel(JButton botao)
	{
		this.setBackground(Janela.AZUL);
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.setLayout(new BorderLayout());
		botao.setBackground(Janela.AZUL_ESCURO);
		this.add(botao, BorderLayout.CENTER);
	}
}
