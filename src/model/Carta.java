package model;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Carta extends JButton{
	private String conteudo;
	private ImageIcon fundo;
	private ImageIcon face;
	private String faceLocal;
	
	public Carta(String conteudo, String localFace) {
		super(new ImageIcon("src/images/jogo/fundoCarta.png"));
		this.conteudo = conteudo;
		fundo = new ImageIcon("src/images/jogo/fundoCarta.png");
		faceLocal = localFace;
		face = new ImageIcon(faceLocal);
		setIcon(fundo);
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

	public String getFaceLocal() {
		return faceLocal;
	}
	
	
}
