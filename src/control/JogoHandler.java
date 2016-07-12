package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Observable;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import app.App;
import model.Carta;
import view.Jogo;

public class JogoHandler implements ActionListener{
	private Jogo jogo;
	private String modo;
	private Carta cartaUm;
	private Carta cartaDois;
	
	
	public JogoHandler(Jogo jogo, String modo) {
		super();
		this.jogo = jogo;
		this.modo=modo;
		carregaCartas();		
		for(Carta carta:jogo.getCartas()){
			carta.addActionListener(this);
		}
		
		cartaUm = null;
		cartaDois = null;
	}
	
	public void carregaCartas(){
		try{
			
			InputStream file = getClass().getResourceAsStream(modo+".txt");
			BufferedReader bufferFile = new BufferedReader(new InputStreamReader(file));
			String linha;
			StringTokenizer st;
			linha=bufferFile.readLine();
			
			while((linha=bufferFile.readLine())!=null){				
				st = new StringTokenizer(linha);
				jogo.getCartas().add(new Carta(st.nextToken(),st.nextToken()));
			}
		}
		catch(Exception e){}
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
				JOptionPane.showMessageDialog(null, "N�o fa�a isso!");
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
				}
				else{
					JOptionPane.showMessageDialog(null, "Errou");
					cartaUm.viraFundo();
					cartaDois.viraFundo();
					cartaUm=null;
					cartaDois=null;
				}
			}
			
		}
	}

	public void acabarPartida() {
		JOptionPane.showMessageDialog(null, "Parab�ns, Voc� conseguiu achar todos os pares em "+jogo.getTime()+" segundos!");
	}
	
	


	
	
	
	
}