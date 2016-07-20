package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import app.App;
import control.TelaJogoController;
import model.Carta;

public class SinglePlayer extends JFrame implements Runnable{
	private ArrayList<Carta> cartas;
	private int pares;
	private JPanel cartasPanel;
	private TelaJogoController controller;
	private int time;
	private boolean condicao;
	
	public SinglePlayer(int largura, int altura, TelaJogoController controller) {
		int linha=0;
		int coluna=0;
		this.controller=controller;
		setSize(largura, altura);
		if(largura==800 && altura==600){
			linha=4;
			coluna=5;
			pares=10;
		}
		if(largura==1024 && altura==768){
			linha=5;
			coluna=6;
			pares=15;
		}
		if(largura==1280 && altura==768){
			linha=6;
			coluna=8;
			pares=24;
		}
		setLayout(null);
		time=0;
		condicao=true;
		setBackground(Color.BLACK);
		cartasPanel = new JPanel();
		cartasPanel.setBackground(Color.BLACK);
		cartasPanel.setBounds(0, 50, 160*coluna, 125*linha);
		cartasPanel.setLayout(new GridLayout(linha,coluna));
		cartasPanel.setVisible(true);		
		add(cartasPanel);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.RED);
		g.setFont(new Font("Arial", Font.BOLD,25));
		g.drawString("Tempo: "+time+"s", 625,60);
		g.drawString("Tentativas: "+App.jogador.getTentativas(), 425, 60);
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
				if(time==5){
					for(Carta carta : cartas){
						carta.viraFundo();
					}
				}
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
		controller.acabarPartida();
		condicao=false;
		Thread.yield();
	}

	public JPanel getCartasPanel() {
		return cartasPanel;
	}
}
