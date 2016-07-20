package app;
import java.util.ArrayList;

import control.ConstriurHandler;
import control.InicioHandler;
import control.ModoHandler;
import control.Controller;
import model.Jogador;
import view.Configuracao;
import view.Construir;
import view.Creditos;
import view.Inicio;
import view.ModoDeJogo;

public class App{	
	public static Jogador jogador1 = new Jogador("");
	public static Jogador jogador2 = new Jogador("");
	public static ArrayList<String> perso = new ArrayList<>();
	public static int largura = 800;
	public static int altura = 600;
	public static void main(String[] args) {
		Creditos cr = new Creditos();
		Configuracao config = new Configuracao();
		Inicio inicio = new Inicio();		
		ModoDeJogo modo = new ModoDeJogo();
		Controller controller = new Controller(inicio, modo);
		InicioHandler inicioHandler = new InicioHandler(inicio,controller,cr,config);
		ModoHandler modoHandler = new ModoHandler(modo,controller);
		Construir c = new Construir();
		ConstriurHandler ch = new ConstriurHandler(c);
		
		
	}
}
