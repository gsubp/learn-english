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
	private JButton configButton;
	private JButton creditosButton;
	private JButton rankingButton;
	
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
		playButton.setBounds(325,245,150,100);
		playButton.setCursor(new Cursor(12)); // hand cursor
		add(playButton);		
		sairButton = new JButton(new ImageIcon("src/images/inicio/sairButton.png"));
		sairButton.setBorder(null);
		sairButton.setBounds(20,470,150,100);
		sairButton.setCursor(new Cursor(12));
		add(sairButton);
		configButton = new JButton(new ImageIcon("src/images/inicio/configButton.png"));
		configButton.setBorder(null);
		configButton.setCursor(new Cursor(12));
		configButton.setBounds(650, 450, 128, 128);
		add(configButton);
		creditosButton = new JButton(new ImageIcon("src/images/inicio/creditosButton.png"));
		creditosButton.setBorder(null);
		creditosButton.setCursor(new Cursor(12));
		creditosButton.setBounds(325, 355, 150, 100);
		add(creditosButton);
		rankingButton = new JButton(new ImageIcon("src/images/inicio/rankingButton.png"));
		rankingButton.setBorder(null);
		rankingButton.setCursor(new Cursor(12));
		rankingButton.setBounds(325,460,150,100);
		add(rankingButton);
		
		
		
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

	public JButton getConfigButton() {
		return configButton;
	}

	public JButton getCreditosButton() {
		return creditosButton;
	}

	public JButton getRankingButton() {
		return rankingButton;
	}
	
	
}
