package view;

import java.awt.Cursor;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import control.TelaInicioHandler;

public class TelaInicio extends JFrame{

	private JLabel back;	
	private JButton playButton;
	private JButton sairButton;
	
	public TelaInicio(){
		super("Learn English ou quase isso!"); 
		setSize(800,600);		
		back = new JLabel(new ImageIcon("src/images/telainicio.png"));
		back.setVisible(true);
		back.setLocation(0,0);
		
		playButton = new JButton(new ImageIcon("src/images/playButton.png"));
		playButton.setBorder(null); //botao sem borda
		playButton.setVisible(true);
		playButton.setBounds(325,325,150,100);
		playButton.setCursor(new Cursor(12)); // hand cursor		
		playButton.addActionListener(new TelaInicioHandler(this));
		back.add(playButton);
		
		
		sairButton = new JButton(new ImageIcon("src/images/sairButton.png"));
		sairButton.setBorder(null);
		sairButton.setVisible(true);
		sairButton.setBounds(325,450,150,100);
		sairButton.setCursor(new Cursor(12)); // hand cursor
		sairButton.addActionListener(new TelaInicioHandler(this));
		back.add(sairButton);
		add(back);
		
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public JButton getPlayButton() {
		return playButton;
	}

	public JButton getSairButton() {
		return sairButton;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TelaInicio();
	}
}
