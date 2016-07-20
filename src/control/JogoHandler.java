package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import org.jdom2.Element;

import app.App;
import model.Carta;
import view.Jogo;
import view.ModoDeJogo;

public class JogoHandler implements ActionListener{
	private Jogo jogo;
	private String modo;
	private Carta cartaUm;
	private Carta cartaDois;
	private TelaJogoController controller;
	public JogoHandler(Jogo jogo, String modo, TelaJogoController controller) {
		super();
		this.jogo = jogo;
		this.modo=modo;
		this.controller=controller;
		jogo.setCartas(new ArrayList<>());
		carregaCartas();
		Collections.shuffle(jogo.getCartas());
		for(Carta carta: jogo.getCartas()){
			jogo.getCartasPanel().add(carta);
		}
		for(Carta carta:jogo.getCartas()){
			carta.addActionListener(this);
			carta.viraFace();
		}		
		cartaUm = null;
		cartaDois = null;
	}
	
	public void carregaCartas(){
		List<Element> memoria = JogoXML.lerXML(modo);
		for(Element e : memoria)
			jogo.getCartas().add(new Carta(e.getChildText("Conteudo"), e.getChildText("face")));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(cartaUm==null){
			cartaUm =(Carta)e.getSource();
			cartaUm.viraFace();
		}
		else{
			cartaDois = (Carta)e.getSource();
			cartaDois.viraFace();
		}
		if(cartaDois!=null){
			if(cartaUm==cartaDois){
				JOptionPane.showMessageDialog(null, "Não faça isso!");
				cartaUm.viraFundo();
				cartaDois.viraFundo();
				cartaUm=null;
				cartaDois=null;
			}
			else{
				if(cartaUm.getConteudo().equals(cartaDois.getConteudo())){
					JOptionPane.showMessageDialog(null, "Acertou");
					cartaUm.setEnabled(false);
					cartaDois.setEnabled(false);
					cartaUm=null;
					cartaDois=null;
					jogo.setPares(jogo.getPares()-1);
					App.jogador.incrementaTentavias();
				}
				else{
					JOptionPane.showMessageDialog(null, "Errou");
					cartaUm.viraFundo();
					cartaDois.viraFundo();
					cartaUm=null;
					cartaDois=null;
					App.jogador.incrementaTentavias();
				}
			}
			
		}
	}

	
	
	
	
	


	
	
	
	
}
