package app;
import control.ConstriurHandler;
import control.InicioHandler;
import control.ModoHandler;
import control.TelaJogoController;
import model.Jogador;
import view.Configuracao;
import view.Construir;
import view.Creditos;
import view.Inicio;
import view.ModoDeJogo;

public class App{	
	public static Jogador jogador = new Jogador("");
	public static void main(String[] args) {
		Creditos cr = new Creditos();
		Configuracao config = new Configuracao();
		Inicio inicio = new Inicio();		
		ModoDeJogo modo = new ModoDeJogo();
		TelaJogoController controller = new TelaJogoController(inicio, modo);
		InicioHandler inicioHandler = new InicioHandler(inicio,controller,cr,config);
		ModoHandler modoHandler = new ModoHandler(modo,controller);
		Construir c = new Construir();
		ConstriurHandler ch = new ConstriurHandler(c);
		
		
	}
}
