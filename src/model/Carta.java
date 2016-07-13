package model;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Carta extends JButton{
	private String conteudo;
	private ImageIcon fundo;
	private ImageIcon face;
	
	public Carta(String conteudo, String localFace) {
		super(new ImageIcon("src/images/jogo/fundoCarta.png"));
		this.conteudo = conteudo;
		fundo = new ImageIcon("src/images/jogo/fundoCarta.png");
		face = new ImageIcon(localFace);
		setIcon(fundo);
//		setBorderPainted(true);
		setVisible(true);
	}

	public String getConteudo() {
		return conteudo;
	}
	
	public void viraFace(){
		setIcon(face);
	}
	public void viraFundo(){
		setIcon(fundo);
	}
}
