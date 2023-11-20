package view;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Banco;

public class ListarVendas extends JPanel {

	Janela janela;
	
	String[] colunas = {"Nome", "Matrícula", "Queijo", "Proteína", "Bebida", "Adicionais"};
	String[][] dados = {{"N1", "M1", "Q1", "P1", "B1", "A1"},
						{"N2", "M2", "Q2", "P2", "B2", "A2"},
						{"N3", "M3", "Q3", "P3", "B3", "A3"},
						{"N4", "M4", "Q4", "P4", "B4", "A4"},
						{"N5", "M5", "Q5", "P5", "B5", "A5"},
						{"N6", "M6", "Q6", "P6", "B6", "A6"},
						{"N7", "M7", "Q7", "P7", "B7", "A7"},
						{"N8", "M8", "Q8", "P8", "B8", "A8"},
						{"N9", "M9", "Q9", "P9", "B9", "A9"}};
	
	JTable tabela = new JTable(dados, colunas);
	JScrollPane painelTabela = new JScrollPane(tabela);
	
	ListarVendas(Janela janela)
	{
		this.janela = janela;
		setSize(Janela.TAMANHO_BAIXO);
		setBackground(Janela.AZUL);
		setLayout(new BorderLayout());
		painelTabela.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		painelTabela.setBackground(Janela.AZUL);
		add(painelTabela);
	}
	
}
