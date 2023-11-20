package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RealizarVendas extends JPanel {

	private Janela janela;
	
	private JTextField nome;
	private JTextField matricula;
	private JComboBox<String> opQueijo;
	private JComboBox<String> opProteina;
	private JCheckBox ketchup;
	private JCheckBox maionese;
	private JCheckBox ovo;
	private JCheckBox batata;
	private JComboBox<String> opBebida;
	private JPanel vazio;
	private JButton realizarVenda;
	
	RealizarVendas(Janela janela)
	{
		this.janela = janela;
		setSize(Janela.TAMANHO_BAIXO);
		setBackground(Janela.AZUL);
		setLayout(new GridLayout(7, 2, 0, 10));
		
		//Nome do cliente
		add(new Painel("Nome do cliente"));
		nome = new JTextField();
		add(new Painel(nome));
		
		//Matricula
		add(new Painel("Matrícula"));
		matricula = new JTextField();
		add(new Painel(matricula));
		
		//Selecionar queijo
		add(new Painel("Opção de queijo"));
		String[] queijos = {null, "Mussarela", "Prato", "Parmesao", "Coalho"};
		opQueijo = new JComboBox<String>(queijos);
		add(new Painel(opQueijo));
		
		//Selecionar proteina
		add(new Painel("Opção de proteína"));
		String[] proteinas = {null, "Salsicha", "Linguiça", "Frango", "Bacon"};
		opProteina = new JComboBox<String>(proteinas);
		add(new Painel(opProteina));
		
		//Selecionar adicionais
		add(new Painel("Escolha os adicionais"));
		ketchup = new JCheckBox();
		ketchup.setText("Ketchup");
		maionese = new JCheckBox();
		maionese.setText("Maionese");
		ovo = new JCheckBox();
		ovo.setText("Ovo");
		batata = new JCheckBox();
		batata.setText("Batata");
		add(new Painel(ketchup, maionese, ovo, batata));
		
		//Selecionar bebida
		add(new Painel("Opção de bebida"));
		String[] bebidas = {null, "Coca-Cola", "Delrio", "Suco do Chaves"};
		opBebida = new JComboBox<String>(bebidas);
		add(new Painel(opBebida));
		
		//Botao de realizar venda
		vazio = new JPanel();
		vazio.setBackground(Janela.AZUL);
		add(vazio);
		realizarVenda = new JButton();
		realizarVenda.setText("Realizar Venda");
		realizarVenda.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				realizarVenda();
			}});
		add(new Painel(realizarVenda));
	}
	
	private String strNome;
	private String strMatricula;
	private int intQueijo;
	private int intProteina;
	private int intBebida;
	private boolean boolKetchup;
	private boolean boolMaionese;
	private boolean boolOvo;
	private boolean boolBatata;
	
	private void realizarVenda()
	{
		System.out.println(formatarVenda());
		if(janela.receberVenda(formatarVenda()) == true)
		{
			limpar();
		}
		else
		{
			vendaInvalida();
		}
	}
	
	private void limpar()
	{
		nome.setText("");
		matricula.setText("");
		opQueijo.setSelectedIndex(0);
		opProteina.setSelectedIndex(0);
		opBebida.setSelectedIndex(0);
		ketchup.setSelected(false);
		maionese.setSelected(false);
		ovo.setSelected(false);
		batata.setSelected(false);
	}
	
	private void vendaInvalida()
	{
		JOptionPane.showMessageDialog(null, "Não foi possível realizar a venda. Cheque as informações e tente novamente.",
			      "Venda não realizada", JOptionPane.ERROR_MESSAGE);
	}
	private String formatarVenda()
	{
		strNome = nome.getText().toUpperCase();
		strMatricula = matricula.getText().toUpperCase();
		intProteina = opProteina.getSelectedIndex();
		intQueijo = opQueijo.getSelectedIndex();
		intBebida = opBebida.getSelectedIndex();
		boolKetchup = ketchup.isSelected();
		boolMaionese = maionese.isSelected();
		boolOvo = ovo.isSelected();
		boolBatata = batata.isSelected();
		
		return new String(strNome + ";" + strMatricula + ";" + intProteina + ";"
						+ intQueijo + ";" + intBebida + ";" 
						+ boolKetchup + ";" + boolMaionese + ";"
						+ boolOvo + ";" + boolBatata + ";\n");
	}
	
}
