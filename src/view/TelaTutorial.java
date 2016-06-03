package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class TelaTutorial extends JFrame{
	BufferedImage backBuffer;
	public TelaTutorial(){
		
		setSize(800, 600);
		setVisible(true);		
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		backBuffer = new BufferedImage(this.getWidth(),this.getHeight() , BufferedImage.TYPE_INT_RGB);
	}
	
	public void desenha(){
		Graphics g = getGraphics();
		Graphics bbg =backBuffer.getGraphics();
		bbg.setColor(Color.black);
		
		g.drawImage(backBuffer, 0, 0, this);
	}
	
	public void run(){
			desenha();
			try{
				Thread.sleep(100);
			} 
			catch(Exception e) {
			    System.out.println("Thread interrompida!");
			}
	}
}
