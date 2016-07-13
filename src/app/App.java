package app;

import model.Jogador;
import view.Inicio;
import view.TelaJogo;

public class App{
	public static TelaJogo jogo = new TelaJogo(new Inicio());
	public static Jogador jogador = new Jogador("");
	
	
	public static void main(String[] args) {
		App.jogo.add(App.jogo.getPanel());
	}
}
