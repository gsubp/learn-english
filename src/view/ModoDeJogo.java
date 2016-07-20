
package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ModoDeJogo extends JFrame{
	private static final long serialVersionUID = 1L;
	private JButton numeroButton;
	private JButton animalButton;
	private JButton corButton;
	private BufferedImage modo;
	private JPanel panel;
	
	public ModoDeJogo() {
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
		
		animalButton = new JButton(new ImageIcon("src/images/modo/animaisButton.png"));
		animalButton.setBounds(590, 250, 200,75);
		animalButton.setBorder(null);
		animalButton.setCursor(new Cursor(12));
		animalButton.setVisible(true);
		corButton = new JButton(new ImageIcon("src/images/modo/coresButton.png"));
		corButton.setBounds(590, 350, 200, 75);		
		corButton.setBorder(null);
		corButton.setCursor(new Cursor(12));
		corButton.setVisible(true);
		numeroButton = new JButton(new ImageIcon("src/images/modo/numerosButton.png"));
		numeroButton.setBounds(590, 450, 200, 75);
		numeroButton.setBorder(null);
		numeroButton.setCursor(new Cursor(12));
		numeroButton.setVisible(true);
		setLayout(null);
		panel.add(animalButton);
		panel.add(corButton);
		panel.add(numeroButton);	
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
