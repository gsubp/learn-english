package control;

import javax.swing.JOptionPane;

import app.App;
import view.Inicio;
import view.Jogo;
import view.ModoDeJogo;
import view.TelaJogo;

public class TelaJogoController{
	private TelaJogo tela;
	private Inicio inicio;
	private ModoDeJogo modo;
	private Jogo jogo;
	private Thread thread;
	private JogoHandler jogoHandler;
	
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
		modo.setVisible(true);
		tela.trocaPanel(modo);
	}

	public void iniciaJogo(String modo) {
		jogo = new Jogo(this);
		jogoHandler = new JogoHandler(jogo,modo,this);	
		tela.trocaPanel(jogo);
		thread = new Thread(jogo);
		thread.start();
	}
	
	public void acabarPartida() {
		JOptionPane.showMessageDialog(null, "Parabéns "+App.jogador.getNome()+", você conseguiu achar todos os pares em "+App.jogador.getTentativas()+" tentativas e em "+jogo.getTime()+" segundos!");
		App.jogador.zeraTentativas();
	}

	public void voltaModo() {
		iniciaModo();
		
	}
}
