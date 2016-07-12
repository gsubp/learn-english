package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import app.App;
import view.Inicio;
import view.ModoDeJogo;

public class InicioHandler implements ActionListener {
	private Inicio inicio;
	
	public InicioHandler(Inicio inicio) {
		super();
		this.inicio=inicio;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==inicio.getPlayButton()){
			ModoDeJogo modo = new ModoDeJogo();
			App.jogo.trocaPanel(modo);
		}
		if(e.getSource()==inicio.getSairButton())
			System.exit(0);

	}

}
