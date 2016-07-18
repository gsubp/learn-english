package app;
import control.InicioHandler;
import control.ModoHandler;
import control.TelaJogoController;
import model.Jogador;
import view.Inicio;
import view.ModoDeJogo;
import view.TelaJogo;

public class App{	
	public static Jogador jogador = new Jogador("");
	public static void main(String[] args) {
		Inicio inicio = new Inicio();		
		ModoDeJogo modo = new ModoDeJogo();
		TelaJogo tela = new TelaJogo();
		TelaJogoController controller = new TelaJogoController(tela, inicio, modo);
		InicioHandler inicioHandler = new InicioHandler(inicio,controller);
		ModoHandler modoHandler = new ModoHandler(modo,controller);
	}
}
