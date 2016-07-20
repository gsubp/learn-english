package view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Construir extends JFrame{
	private JLabel tipoLabel;
	private JLabel nomeLabel;
	private JLabel image1label;
	private JLabel image2Label;
	private JLabel contLabel;
	private JTextField tipoField;
	private JTextField nomeField;
	private JTextField image1Field;
	private JTextField image2Field;
	private JButton addButton;
	private JButton salvarButton;
	private int quant;
	
	public Construir() {
		// TODO Auto-generated constructor stub
		quant = 0;
		setSize(200,200);
		setLayout(new FlowLayout());
		tipoLabel = new JLabel("Tipo:");
		tipoLabel.setVisible(true);
		tipoField = new JTextField(10);
		tipoField.setVisible(true);
		nomeLabel = new JLabel("Nome:");
		nomeLabel.setVisible(true);
		nomeField = new JTextField(10);
		nomeField.setVisible(true);
		image1label = new JLabel("Imagem 1:");
		image1label.setVisible(true);
		image1Field = new JTextField(10);
		image1Field.setVisible(true);
		image2Label = new JLabel("Imagem 2:");
		image2Label.setVisible(true);
		image2Field = new JTextField(10);
		image2Field.setVisible(true);
		contLabel = new JLabel("Quantidade de Cartas: "+quant);
		contLabel.setVisible(true);
		addButton = new JButton("Add");
		addButton.setVisible(true);
		salvarButton = new JButton("Salvar");
		salvarButton.setVisible(true);
		add(tipoLabel);
		add(tipoField);
		add(nomeLabel);
		add(nomeField);
		add(image1label);
		add(image1Field);
		add(image2Label);
		add(image2Field);
		add(contLabel);
		add(addButton);
		add(salvarButton);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	public JTextField getTipoField() {
		return tipoField;
	}

	public JTextField getNomeField() {
		return nomeField;
	}

	public JTextField getImage1Field() {
		return image1Field;
	}

	public JTextField getImage2Field() {
		return image2Field;
	}

	public JButton getAddButton() {
		return addButton;
	}

	public JButton getSalvarButton() {
		return salvarButton;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

	public JLabel getContLabel() {
		return contLabel;
	}
	
	
}
