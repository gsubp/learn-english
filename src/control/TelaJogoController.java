package control;

import javax.swing.JOptionPane;

import app.App;
import view.Inicio;
import view.ModoDeJogo;
import view.SinglePlayer;

public class TelaJogoController{
	private Inicio inicio;
	private ModoDeJogo modo;
	private SinglePlayer single;
	private Thread thread;
	private SinglePlayerController singleController;
	
	public TelaJogoController(Inicio inicio, ModoDeJogo modo) {
		super();
		this.inicio = inicio;
		this.modo = modo;
		inicio();
	}

	public void inicio() {
		inicio.setVisible(true);		
	}

	public void iniciaJogo(String tipo) {
		modo.setVisible(false);
		single = new SinglePlayer(800, 600, this);
		singleController = new SinglePlayerController(single,tipo,this);	
		thread = new Thread(single);
		thread.start();
	}
	
	public void acabarPartida() {
		JOptionPane.showMessageDialog(null, "Parabéns "+App.jogador.getNome()+", você conseguiu achar todos os pares em "+App.jogador.getTentativas()+" tentativas e em "+single.getTime()+" segundos!");
		App.jogador.zeraTentativas();
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
