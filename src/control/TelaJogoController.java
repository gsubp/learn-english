package control;

import javax.swing.JOptionPane;

import app.App;
import view.Inicio;
import view.ModoDeJogo;
import view.SinglePlayer;
import view.TelaJogo;

public class TelaJogoController{
	private TelaJogo tela;
	private Inicio inicio;
	private ModoDeJogo modo;
	private SinglePlayer single;
	private Thread thread;
	private SinglePlayerController singleController;
	
	public TelaJogoController(TelaJogo tela, Inicio inicio, ModoDeJogo modo) {
		super();
		this.tela = tela;
		this.inicio = inicio;
		this.modo = modo;
		iniciaTela();	
	}

	public void iniciaTela(){
		tela.trocaPanel(inicio);
	}
	
	public void iniciaModo(){
		tela.setPanel(modo);
	}

	public void iniciaJogo(String modo) {
		tela.setVisible(false);
		single = new SinglePlayer(800, 600, this);
		singleController = new SinglePlayerController(single,modo,this);	
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
		tela.setVisible(true);
		iniciaModo();
	}
}
