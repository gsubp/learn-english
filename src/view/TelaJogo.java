package view;

import java.awt.Color;

import javax.swing.JFrame;

import javax.swing.JPanel;

public class TelaJogo extends JFrame{
	private JPanel panel;
	
	public TelaJogo(){
		setBackground(Color.BLACK);
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
		if(this.panel==null)
			this.panel=panel;
		else{		
			this.panel.setVisible(false);
			this.panel=panel;
		}
		add(this.panel);
	}		
}

