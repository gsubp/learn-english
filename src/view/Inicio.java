package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Inicio extends JPanel{
	private BufferedImage logo;	
	private JButton playButton;
	private JButton sairButton;
	
	public Inicio() {
		setLayout(null);
		try {
			logo = ImageIO.read(new File("src/images/inicio/telainicio.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setBackground(Color.BLACK);
		
		playButton = new JButton(new ImageIcon("src/images/inicio/playButton.png"));
		playButton.setBorder(null); //botao sem borda
		playButton.setVisible(true);
		playButton.setBounds(325,275,150,100);
		playButton.setCursor(new Cursor(12)); // hand cursor
		add(playButton);		
		sairButton = new JButton(new ImageIcon("src/images/inicio/sairButton.png"));
		sairButton.setBorder(null);
		sairButton.setVisible(true);
		sairButton.setBounds(325,400,150,100);
		sairButton.setCursor(new Cursor(12));
		add(sairButton);
		setVisible(true);
	}

	public JButton getPlayButton() {
		return playButton;
	}

	public JButton getSairButton() {
		return sairButton;
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(logo,0, 50,null);
	}
	
	
}
