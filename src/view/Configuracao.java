package view;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class Configuracao extends JFrame{
	private JLabel resolucaoLabel;
	private JRadioButton resolucao800;
	private JRadioButton resolucao1024;
	private JRadioButton resolucao1280;
	private JLabel quantLabel;
	private JButton okButton;
	private ButtonGroup group;
	private int qnt;
	
	public Configuracao(){
		setLayout(new FlowLayout());
		setSize(165,180);
		qnt = 10;
		resolucaoLabel = new JLabel("Resolução: ");
		resolucao800 = new JRadioButton("800x600", true);
		resolucao1024 = new JRadioButton("1024x768", false);
		resolucao1280 = new JRadioButton("1280x768", false);
		group = new ButtonGroup();
		group.add(resolucao800);
		group.add(resolucao1024);
		group.add(resolucao1280);
		quantLabel = new JLabel("Quantidade de Pares: "+qnt);
		okButton = new JButton("OK");
		
		add(resolucaoLabel);
		add(resolucao800);
		add(resolucao1024);
		add(resolucao1280);
		add(quantLabel);
		add(okButton);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(false);
		
		
	}
}
