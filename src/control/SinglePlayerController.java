package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import org.jdom2.Element;
import app.App;
import model.Carta;
import view.SinglePlayer;

public class SinglePlayerController implements ActionListener{
	private SinglePlayer singlePlayer;
	private String modo;
	private Carta cartaUm;
	private Carta cartaDois;
	private Controller controller;
	public SinglePlayerController(SinglePlayer singlePlayer, String modo, Controller controller) {
		super();
		this.singlePlayer = singlePlayer;
		this.modo=modo;
		this.controller=controller;
		singlePlayer.setCartas(new ArrayList<>());
		carregaCartas();
		Collections.shuffle(singlePlayer.getCartas());
		for(Carta carta: singlePlayer.getCartas()){
			singlePlayer.getCartasPanel().add(carta);
		}
		for(Carta carta:singlePlayer.getCartas()){
			carta.addActionListener(this);
			carta.viraFace();
		}		
		cartaUm = null;
		cartaDois = null;
	}
	
	public void carregaCartas(){
		List<Element> memoria = JogoXML.lerXML(modo);
		for(Element e : memoria)
			singlePlayer.getCartas().add(new Carta(e.getChildText("Conteudo"), e.getChildText("face")));
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
					singlePlayer.setPares(singlePlayer.getPares()-1);
					App.jogador1.incrementaTentavias();
				}
				else{
					JOptionPane.showMessageDialog(null, "Errou");
					cartaUm.viraFundo();
					cartaDois.viraFundo();
					cartaUm=null;
					cartaDois=null;
					App.jogador1.incrementaTentavias();
				}
			}
			
		}
	}

	
	
	
	
	


	
	
	
	
}
