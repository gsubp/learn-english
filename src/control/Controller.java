package control;

import javax.swing.JOptionPane;

import app.App;
import view.Inicio;
import view.ModoDeJogo;
import view.MultiPlayer;
import view.SinglePlayer;

public class Controller{
	private Inicio inicio;
	private ModoDeJogo modo;
	private SinglePlayer single;
	private MultiPlayer multi;
	private Thread thread;
	private SinglePlayerController singleController;
	
	public Controller(Inicio inicio, ModoDeJogo modo) {
		super();
		this.inicio = inicio;
		this.modo = modo;
		inicio();
	}

	public void inicio() {
		inicio.setVisible(true);		
	}

	public void iniciaJogo(String tipo, boolean multiplayer) {
		modo.setVisible(false);
		if(multiplayer){
			multi = new MultiPlayer(App.largura,App.altura, this);
			singleController = new SinglePlayerController(multi, tipo, this);
			thread = new Thread(multi);
			
		}
		else{
			single = new SinglePlayer(App.largura,App.altura, this);
			singleController = new SinglePlayerController(single,tipo,this);	
			thread = new Thread(single);
			
		}
		thread.start();
		
	}
	
	public void acabarPartida() {
		JOptionPane.showMessageDialog(null, "Parabéns "+App.jogador1.getNome()+", você conseguiu achar todos os pares em "+App.jogador1.getTentativas()+" tentativas e em "+single.getTime()+" segundos!");
		App.jogador1.zeraTentativas();
		single.setVisible(false);
		single=null;
		thread=null;
		System.gc();
		modo();
	}

	public void modo() {
		modo.setVisible(true);
		
	}
}
