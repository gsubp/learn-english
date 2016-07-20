package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Creditos extends JFrame{
	private BufferedImage image;
	public Creditos() {
		setSize(800, 600);
		setDefaultCloseOperation(HIDE_ON_CLOSE);		
		try {
			image = ImageIO.read(new File("src/images/creditos/creditos.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setResizable(false);
		setVisible(false);
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(image, 0, 0, null);
		
	}
}
