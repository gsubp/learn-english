
package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.App;

public class ModoDeJogo extends JFrame{
	private static final long serialVersionUID = 1L;
	private JButton numeroButton;
	private JButton animalButton;
	private JButton corButton;
	private BufferedImage modo;
	private JPanel panel;
	private JButton singleButton;
	private JButton multiButton;
	private JLabel nome1label;
	private JLabel nome2label;
	private JTextField nome1Field;
	private JTextField nome2Field;
	private JButton persoButton;
	private JComboBox<String> perso;
	private JButton voltarButton;
	public ModoDeJogo() {
		setLayout(null);
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setSize(800, 600);
		panel.setLayout(null);
		setSize(800, 600);
		setBackground(Color.BLACK);

		try{
			modo = ImageIO.read(new File("src/images/modo/modoJogoImage.png"));
		}
		catch(Exception e){
			System.out.println("Arquivo não encontrado ou não pode ser lido");
		}
		
		voltarButton = new JButton("Voltar");
		voltarButton.setBounds(10,10, 100,50);
		panel.add(voltarButton);
		
		singleButton = new JButton("Single Player");
		singleButton.setBounds(45,200,200,50);
		panel.add(singleButton);
		
		multiButton = new JButton("Multiplayer");
		multiButton.setBounds(45,260, 200,50);
		panel.add(multiButton);
		
		nome1label = new JLabel("Jogador 1: ");
		nome1label.setForeground(Color.GREEN);
		nome1label.setBounds(45, 320,75,25);
		nome1label.setVisible(false);
		panel.add(nome1label);
		
		nome1Field = new JTextField(10);
		nome1Field.setBounds(120,320,125,25);
		nome1Field.setVisible(false);
		panel.add(nome1Field);
		
		nome2label = new JLabel("Jogador 2: ");
		nome2label.setBounds(45, 350, 75, 25);
		nome2label.setForeground(Color.GREEN);
		nome2label.setVisible(false);
		panel.add(nome2label);
		
		nome2Field = new JTextField(10);
		nome2Field.setBounds(120, 350, 125, 25);
		nome2Field.setVisible(false);
		panel.add(nome2Field);
		
		animalButton = new JButton(new ImageIcon("src/images/modo/animaisButton.png"));
		animalButton.setBounds(270, 180, 200,75);
		animalButton.setBorder(null);
		animalButton.setCursor(new Cursor(12));
		animalButton.setVisible(false);
		panel.add(animalButton);
		
		corButton = new JButton(new ImageIcon("src/images/modo/coresButton.png"));
		corButton.setBounds(270, 260, 200, 75);		
		corButton.setBorder(null);
		corButton.setCursor(new Cursor(12));
		corButton.setVisible(false);
		panel.add(corButton);
		
		numeroButton = new JButton(new ImageIcon("src/images/modo/numerosButton.png"));
		numeroButton.setBounds(270,340, 200, 75);
		numeroButton.setBorder(null);
		numeroButton.setCursor(new Cursor(12));
		numeroButton.setVisible(false);
		panel.add(numeroButton);	
		
		persoButton = new JButton(new ImageIcon("src/images/modo/persoButton.png"));
		persoButton.setBorder(null);
		persoButton.setCursor(new Cursor(12));
		persoButton.setBounds(480,180,200,75);
		persoButton.setVisible(false);
		panel.add(persoButton);
		
		perso = new JComboBox<>(carregaPerso());
		perso.setBounds(480, 265, 200, 25);
		perso.setSelectedIndex(0);
		perso.setVisible(false);
		panel.add(perso);		
		
		add(panel);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setVisible(false);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(modo, 100, 50, null);
	}
	
	public String[] carregaPerso(){
		String[] perso = new String[App.perso.size()+1];
		perso[0]="Escolha um modo personalizado";
		for(int i=1;i<perso.length;i++){
			perso[i]=App.perso.get(i-1);
		}
		return perso;
	}

	public JButton getNumeroButton() {
		return numeroButton;
	}

	public JButton getAnimalButton() {
		return animalButton;
	}

	public JButton getCorButton() {
		return corButton;
	}

	public JButton getSingleButton() {
		return singleButton;
	}

	public JButton getMultiButton() {
		return multiButton;
	}

	public JLabel getNome1label() {
		return nome1label;
	}

	public JLabel getNome2label() {
		return nome2label;
	}

	public JTextField getNome1Field() {
		return nome1Field;
	}

	public JTextField getNome2Field() {
		return nome2Field;
	}

	public JButton getPersoButton() {
		return persoButton;
	}

	public JComboBox<String> getPerso() {
		return perso;
	}

	public JButton getVoltarButton() {
		return voltarButton;
	}
}
