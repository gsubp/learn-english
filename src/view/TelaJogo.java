package view;

import java.awt.Color;

import javax.swing.JFrame;

import javax.swing.JPanel;

public class TelaJogo extends JFrame{
	private JPanel panel;
	
	public TelaJogo(JPanel panel){
		setBackground(Color.BLACK);
		this.panel=panel;
		setSize(800,600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	public JPanel getPanel() {
		return panel;
	}
	public void trocaPanel(JPanel panel) {
		this.panel.setVisible(false);
		remove(this.panel);
		this.panel=null;
		this.panel=panel;
		add(this.panel);
		System.gc();
	}		
}
