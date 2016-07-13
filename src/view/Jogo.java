package view;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JPanel;

import app.App;
import control.JogoHandler;
import model.Carta;
import model.Jogador;

public class Jogo extends JPanel implements Runnable{
	private ArrayList<Carta> cartas;
	private int pares;
	private JPanel cartasPanel;
	private JogoHandler jogoHandler;
	private int time;
	private boolean condicao;
	
	public Jogo(String modo){
		setLayout(null);
		pares=10;
		time=0;
		condicao=true;
		setBackground(Color.BLACK);
		cartasPanel = new JPanel();
		cartasPanel.setBackground(Color.BLACK);
		cartasPanel.setBounds(0, 50, 800, 525);
		cartasPanel.setLayout(new GridLayout(4,5));
		cartasPanel.setVisible(true);		
		add(cartasPanel);
		cartas = new ArrayList<>();
		jogoHandler = new JogoHandler(this,modo);		
		Collections.shuffle(cartas);
		for(Carta carta: cartas){
			cartasPanel.add(carta);
		}
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.RED);
		g.setFont(new Font("Arial", Font.BOLD,25));
		g.drawString("Tempo: "+time+"s", 625,35);
		g.drawString("Tentativas: "+App.jogador.getTentativas(), 425, 35);
		incrementaTempo(getTime()+1);
	}
	public ArrayList<Carta> getCartas() {
		return cartas;
	}
	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}
	public int getPares() {
		return pares;
	}
	public void setPares(int pares) {
		this.pares = pares;
	}

	public int getTime() {
		return time;
	}

	public void incrementaTempo(int time) {
		this.time = time;
	}

	@Override
	public void run() {
		while(condicao){
			try {
				
				repaint();
				if(pares==0)
					fim();			
				Thread.sleep(1000);				
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}	
	private void fim() {
		jogoHandler.acabarPartida();
		condicao=false;
		Thread.yield();
		jogoHandler.voltaModo();
	}
	
}

	
