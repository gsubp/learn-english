package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import control.ModoHandler;


public class ModoDeJogo extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton numeroButton;
	private JButton animalButton;
	private JButton corButton;
	private BufferedImage modo;
	
	public ModoDeJogo() {
		setBackground(Color.BLACK);

		try{
			modo = ImageIO.read(new File("src/images/modo/modoJogoImage.png"));
		}
		catch(Exception e){
			System.out.println("Arquivo n�o encontrado ou n�o pode ser lido");
		}
		
		animalButton = new JButton(new ImageIcon("src/images/modo/animaisButton.png"));
		animalButton.setBounds(300, 250, 200,75);
		animalButton.setBorder(null);
		animalButton.setCursor(new Cursor(12));
		animalButton.setVisible(true);
		animalButton.addActionListener(new ModoHandler(this));
		corButton = new JButton(new ImageIcon("src/images/modo/coresButton.png"));
		corButton.setBounds(300, 350, 200, 75);		
		corButton.setBorder(null);
		corButton.setCursor(new Cursor(12));
		corButton.setVisible(true);
		corButton.addActionListener(new ModoHandler(this));
		numeroButton = new JButton(new ImageIcon("src/images/modo/numerosButton.png"));
		numeroButton.setBounds(300, 450, 200, 75);
		numeroButton.setBorder(null);
		numeroButton.setCursor(new Cursor(12));
		numeroButton.setVisible(true);
		numeroButton.addActionListener(new ModoHandler(this));
		setLayout(null);
		add(animalButton);
		add(corButton);
		add(numeroButton);		
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(modo, 100, 50, null);
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
}